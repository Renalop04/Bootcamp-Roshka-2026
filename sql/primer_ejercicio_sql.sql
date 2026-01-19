/*1) Top clientes con más facturas*/
SELECT cliente_id, count(*) As total_facturas
FROM factura
GROUP BY cliente_id
ORDER BY total_facturas DESC
limit 5;

/*2) Top clientes que más gastaron*/
SELECT 
    c.nombre, 
    c.apellido, 
    SUM(d.cantidad * p.precio) AS total_gastado
FROM cliente c
JOIN factura f ON c.id = f.cliente_id
JOIN factura_detalle d ON f.id = d.factura_id
JOIN producto p ON d.producto_id = p.id
GROUP BY c.id, c.nombre, c.apellido
ORDER BY total_gastado DESC
LIMIT 5;

/*3) Top monedas más utilizadas*/
select
	m.nombre,
	count (f.id )  as cantidad
from factura f 
join moneda m on f.moneda_id = m.id 
group by m.nombre
order by cantidad desc
limit 5;

/*4) Top proveedor de productos*/
select 
	pr.nombre,
	SUM(f.cantidad * p.precio) as Top_proveedores_de_productos 
from factura_detalle f
join producto p  on f.producto_id = p.id 
join proveedor pr on p.proveedor_id = pr.id 
group by pr.nombre  
order by Top_proveedores_de_productos desc
limit 10;

/*5) Productos mas vendidos*/
select
	p.nombre, 
	sum(f.cantidad) as Productos_mas_vendidos
from factura_detalle f
join producto p on f.producto_id = p.id
group by p.nombre
order by Productos_mas_vendidos desc
limit 5;

/*6)Productos menos vendidos*/
select
	p.nombre, 
	sum(f.cantidad) as Productos_menos_vendidos
from factura_detalle f
join producto p on f.producto_id = p.id
group by p.nombre
order by Productos_menos_vendidos asc
limit 5;

/*7) Consulta que muestre fecha de emisión de factura, nombre y apellido del cliente, nombres de productos de 
esa factura, cantidades compradas, nombre de tipo de factura de una factura específica*/
select 
	f.fecha_emision,
	c.nombre,
	c.apellido,
	p.nombre,
	fd.cantidad,
	ft.nombre 
from factura f
join cliente c on f.cliente_id = c.id
join factura_detalle fd on f.id = fd.factura_id 
join producto p on fd.producto_id = p.id
join factura_tipo ft on f.factura_tipo_id = ft.id 
where f.id = 5;

/*8) Montos de facturas ordenadas según totales*/
select 
	f.id,
	sum(fd.cantidad * p.precio) as monto_ordenados
from factura f
join factura_detalle fd on f.id = fd.factura_id
join producto p on fd.producto_id = p.id
group by f.id  
order by monto_ordenados  desc
limit 5;

/*9) Mostrar el iva 10% de los montos totales de facturas (suponer que todos los productos tienen IVA 10%)*/
select 
	f.id,
	sum(fd.cantidad * p.precio) as monto_ordenados,
	sum(fd.cantidad * p.precio) * 0.10 as iva
from factura f
join factura_detalle fd on f.id = fd.factura_id
join producto p on fd.producto_id = p.id
group by f.id  
order by f.id;
limit 5;