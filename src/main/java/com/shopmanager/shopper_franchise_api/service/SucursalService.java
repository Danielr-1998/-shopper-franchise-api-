package com.shopmanager.shopper_franchise_api.service;

import com.shopmanager.shopper_franchise_api.model.Producto;
import com.shopmanager.shopper_franchise_api.model.Sucursal;
import com.shopmanager.shopper_franchise_api.repository.ProductoRepository;
import com.shopmanager.shopper_franchise_api.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class SucursalService {

    @Autowired
    private SucursalRepository sucursalRepository;

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Modificar la cantidad en stock de un producto
     */
    public Producto modificarStock(Long productoId, int nuevaCantidad) {
        // Buscar el producto por su ID
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Actualizar la cantidad en stock del producto
        producto.setCantidadEnStock(nuevaCantidad);

        // Guardar el producto con la nueva cantidad
        return productoRepository.save(producto);
    }
    /**
     * Agregar un nuevo producto a una sucursal
     */
    public Sucursal agregarProducto(Long sucursalId, Producto producto) {
        // Buscar la sucursal por su ID
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        // Asignar la sucursal al producto
        producto.setSucursal(sucursal);

        // Guardar el producto
        productoRepository.save(producto);

        // Añadir el producto a la lista de productos de la sucursal
        sucursal.getProductos().add(producto);

        // Actualizar la sucursal
        return sucursalRepository.save(sucursal);
    }

    /**
     * Eliminar un producto de una sucursal
     */
    public Sucursal eliminarProducto(Long sucursalId, Long productoId) {
        // Buscar la sucursal por su ID
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        // Buscar el producto por su ID
        Producto producto = productoRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        // Eliminar el producto de la lista de productos de la sucursal
        sucursal.getProductos().remove(producto);

        // Eliminar el producto de la base de datos
        productoRepository.delete(producto);

        // Actualizar la sucursal
        return sucursalRepository.save(sucursal);
    }
    /**
     * Obtener el producto con más stock en una sucursal.
     *
     * @param sucursalId ID de la sucursal
     * @return El producto con más stock en la sucursal
     */
    public Producto obtenerProductoConMasStock(Long sucursalId) {
        // Buscar la sucursal por su ID
        Sucursal sucursal = sucursalRepository.findById(sucursalId)
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        // Obtener los productos de la sucursal
        List<Producto> productos = sucursal.getProductos();

        // Encontrar el producto con más stock (usando un comparador)
        Optional<Producto> productoConMasStock = productos.stream()
                .max(Comparator.comparingInt(Producto::getCantidadEnStock));

        // Retornar el producto con más stock, si existe
        return productoConMasStock.orElseThrow(() -> new RuntimeException("No hay productos disponibles en esta sucursal"));
    }
}
