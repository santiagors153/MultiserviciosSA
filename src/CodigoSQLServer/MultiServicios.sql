create database MultiserviciosSA
go
use MultiserviciosSA
go
create table Usuario(
Usuario varchar (30),
Contraseña varchar (30)
)
go
create table TipoMovimiento(
idTipoMovimiento int identity(1,1),
descripcion varchar(20),
constraint pkTipoMovimiento primary key(idTipoMovimiento))
go
create table Movimiento(
idMovimiento int identity(1,1),
anioMov int not null,
mesMov int not null,
diaMov int not null,
idTipoMovimiento int not null,
constraint pkMovimiento primary key (idMovimiento),
constraint fkTipoMovimiento foreign key(idTipoMovimiento)references TipoMovimiento)
go
create table Proveedor(
idProveedor int identity(1,1),
nombreProvee varchar(50)not null,
constraint pkProveedor primary key (idProveedor))
go
create table TipoProducto(
idTipoProducto int identity(1,1),
descripcionTipPro int not null,
constraint pkTipoProducto primary key (idTipoProducto))
go
create table Producto(
idProducto int identity (1,1),
codigoProduc varchar(20) not null,
nombreProduc varchar(30) not null,
idTipoProducto int not null,
fechaVencimiento varchar (20) not null,
nroLoteProduc int not null,
precioProducto decimal (18,0) not null,
cantidadProduc decimal (18,0)not null,
stockProducto decimal (18,0) not null,
unidadProduc varchar(50) not null,
idProveedor int not null,
idMovimiento int not null,
constraint pkProducto primary key (idProducto),
constraint fkTipoProducto foreign key(idTipoProducto)references TipoProducto,
constraint fkProveedor foreign key(idProveedor)references Proveedor,
constraint fkMovimiento foreign key(idMovimiento)references Movimiento)
go
exec MostrarStock
go
drop table
go
--Entrada Producto--
alter proc EntradaStock(@codigo varchar(30),@Cantida decimal(18,0))
as begin
update Producto set stockProducto=(stockProducto+@Cantida)
where @codigo = codigoProduc
end
go
exec EntradaStock '16101088',20
select * from Producto
--Salida Producto--
alter proc SalidaStock(@codigo varchar(30),@Cantida decimal(18,0))
as begin
update Producto set stockProducto=(stockProducto-@Cantida)
where @codigo = codigoProduc
end
go
select * from Producto
exec SalidaStock '16101088',5
--Insertear Movimiento 1 y 2--
create proc insertarMovimiento(@descripcion varchar(20))
as begin
insert into TipoMovimiento(descripcion) values (@descripcion)
end
go
exec insertarMovimiento 'Salida'
select * from Movimiento
--Mostrar Stock--
alter proc MostrarStock
as begin
select p.codigoProduc,tp.descripcionTipPro,p.nombreProduc,p.precioProducto,m.anioMov,m.mesMov,m.diaMov,tm.descripcion,p.cantidadProduc,p.unidadProduc,p.fechaVencimiento,p.nroLoteProduc,pe.nombreProvee,p.stockProducto
FROM dbo.Producto p
inner join Movimiento m on p.idMovimiento = m.idMovimiento
inner join TipoMovimiento tm on m.idTipoMovimiento = tm.idTipoMovimiento
inner join TipoProducto tp on p.idTipoProducto = tp.idTipoProducto
inner join Proveedor pe on p.idProveedor = pe.idProveedor
end
go
exec MostrarStock
--Procedimiento Almacenado para Insertar los datos--
alter proc EntradaProducto(@descripcion varchar(20),@codigoProduc varchar(20),@descripcionTipPro int ,@nombreProduc varchar(30),@aniMov int,@mesMov int,@diaMov int,@fechaVencimiento varchar (20),@nombreProvee varchar (50),@unidadProduc varchar(50),@nroLoteProduc int,@precioProducto decimal(18,0),@cantidadProducto decimal(18,0),@stockProducto decimal(18,1))
as begin

declare @idipoovi int, @idtipro int, @idprove int, @movi int
insert into Proveedor(nombreProvee) values (@nombreProvee)

select @idipoovi=idTipoMovimiento from TipoMovimiento
where descripcion = @descripcion
insert into Movimiento(anioMov,mesMov,diaMov,idTipoMovimiento) values (@aniMov,@mesMov,@diaMov,@idipoovi)
insert into TipoProducto(descripcionTipPro) values (@descripcionTipPro)
select @idprove=idProveedor from Proveedor
where nombreProvee = @nombreProvee
select @movi = idMovimiento from Movimiento
where anioMov = @aniMov and mesMov = @mesMov and diaMov = @diaMov and idTipoMovimiento = @idipoovi
select @idtipro = idTipoProducto from TipoProducto
where descripcionTipPro = @descripcionTipPro
insert into Producto(codigoProduc,nombreProduc,idTipoProducto,fechaVencimiento,nroLoteProduc,precioProducto,stockProducto,cantidadProduc,unidadProduc,idProveedor,idMovimiento) values (@codigoProduc,@nombreProduc,@idtipro,@fechaVencimiento,@nroLoteProduc,@precioProducto,@stockProducto,@cantidadProducto,@unidadProduc,@idprove,@movi)
end
go
--Procedimiento de Modificar de datos--
create procedure ModificarProducto(@descripcion varchar(20),@codigoProduc varchar(20),@descripcionTipPro varchar(20),@nombreProduc varchar(30),@aniMov int,@mesMov int,@diaMov int,@fechaVencimiento varchar (20),@nombreProvee varchar (50),@unidadProduc varchar(50),@nroLoteProduc int,@precioProducto decimal(18,0),@cantidadProducto decimal(18,0),@stockProducto decimal(18,0))
as
update Producto set codigoProduc=@codigoProduc,nombreProduc=@nombreProduc,fechaVencimiento=@fechaVencimiento,
nroLoteProduc=@nroLoteProduc,precioProducto=@precioProducto,stockProducto=@stockProducto,cantidadProduc=@cantidadProducto,
unidadProduc=@unidadProduc
where codigoProduc=@codigoProduc
update TipoProducto set descripcionTipPro=@descripcionTipPro
where descripcionTipPro=@descripcionTipPro
update Proveedor set nombreProvee=@nombreProvee
where nombreProvee=@nombreProvee
update Movimiento set anioMov=@aniMov, mesMov=@mesMov,diaMov=@diaMov
where anioMov = @aniMov
go
--Preoceimineto almacenado de busqueda de datos--
alter procedure BuscarDatos(@codigoProducto varchar(20))
as begin
select p.codigoProduc,tp.descripcionTipPro,p.nombreProduc,p.precioProducto,m.anioMov,m.mesMov,m.diaMov,tm.descripcion,p.cantidadProduc,p.unidadProduc,p.fechaVencimiento,p.nroLoteProduc,pe.nombreProvee,p.stockProducto FROM Producto p
inner join Movimiento m on p.idMovimiento = m.idMovimiento
inner join TipoMovimiento tm on m.idTipoMovimiento = tm.idTipoMovimiento
inner join TipoProducto tp on p.idTipoProducto = tp.idTipoProducto
inner join Proveedor pe on p.idProveedor = pe.idProveedor
where @codigoProducto=p.codigoProduc
end
go
select * from Producto
exec BuscarDatos '16101088'
go	
select * from Producto
exec MostrarStock

--Procedimiento Almacenado que agrega Usuarios--
create proc AgregarUsuario(@Usuario varchar(30),@Contraseña varchar(30))
as begin
insert into Usuario values (@Usuario, @Contraseña)
end
go
--Procedimiento Almacenado que Modifique los Usuarios
create proc ModificarUsuario(@Usuario varchar(30),@Contraseña varchar(30))
as
update Usuario set @Usuario=Usuario, @Contraseña = Contraseña 
where @Usuario = Usuario
go
--Procedimiento Almacenado que Busque los Usuarios--
create proc BuscaUsuario(@Usuario varchar(30))
as begin
select Usuario,Contraseña from Usuario
where @Usuario = Usuario
end
go
--Procedimineto Alamacenado que Muestre los datos--
create proc MostrarUsuari
as begin
select Usuario,Contraseña from Usuario
end
go



