select ctgh.ID_ChiTietGioHang, ctgh.ID_GioHang, ctgh.ID_SanPham, ctgh.SoLuong, sp.TenSanPham, sp.Gia, sp.HinhAnh,gh.ID_KhachHang from ChiTietGioHang ctgh join SanPham sp on ctgh.ID_SanPham = sp.ID_SanPham
join GioHang gh on gh.ID_GioHang = ctgh.ID_GioHang where gh.ID_KhachHang = 2

alter table ChiTietGioHang drop column giataithoidiemthem


SELECT 
    sp.TenSanPham, 
    ctgh.SoLuong
FROM 

    KhachHang kh
INNER JOIN GioHang gh ON kh.ID_KhachHang = gh.ID_KhachHang
INNER JOIN ChiTietGioHang ctgh ON gh.ID_GioHang = ctgh.ID_GioHang
INNER JOIN SanPham sp ON ctgh.ID_SanPham = sp.ID_SanPham
WHERE 
    kh.ID_KhachHang = 2;

	SELECT * FROM Giohang 
select *from ChiTietGioHang	

SELECT ctgh.ID_ChiTietGioHang, ctgh.soluong, sp.TenSanPham, sp.Gia, sp.HinhAnh
FROM ChiTietGioHang ctgh
INNER JOIN SanPham sp ON ctgh.ID_SanPham = sp.ID_SanPham
INNER JOIN GioHang gh ON ctgh.ID_GioHang = gh.ID_GioHang
INNER JOIN KhachHang kh ON gh.ID_KhachHang = kh.ID_KhachHang
WHERE gh.ID_GioHang = 2;


delete ChiTietGioHang where id_ChiTietGioHang  = 11


select *from GioHang
go 

select k.hoten, t.TAIKHOAN, t.MATKHAU, t.VAITRO, k.ID_KhachHang, g.ID_GioHang from khachhang k join taikhoan t on k.ID_TAIKHOAN = t.id 
						join giohang g on g.ID_KhachHang = k.ID_KhachHang where t.TAIKHOAN ='cangngo'

select *from KhachHang join TAIKHOAN on KhachHang.ID_TAIKHOAN = TAIKHOAN.id
select *from giohang

update taikhoan set taikhoan = 'canguser', matkhau ='cang123123' where id =3
go

create or alter proc SP_InsertUser 
	@tenDangnhap varchar(100), 
	@email varchar(100), 
	@matkhau varchar(100),
	@hoten nvarchar(100)
AS 
BEGIN	
	BEGIN TRANSACTION
		INSERT INTO TAIKHOAN(TAIKHOAN, MATKHAU, VAITRO)
		VALUES (@tenDangnhap, @matkhau, 'user')
	
		INSERT INTO KhachHang(hoten, email)
		VALUES (@hoten, @email)

		DECLARE @idKhachhang INT = SCOPE_IDENTITY();

		INSERT INTO GioHang(id_khachhang, ngaytao )
		VALUES (@idKhachhang, getdate())

END


--CHAT GPT 
GO

select * from taikhoan  join khachhang  on KhachHang.ID_TAIKHOAN = TAIKHOAN.ID where ID = 100 or TAIKHOAN = 'ngotancanguserr' or MATKHAU ='2323'
go 
USE BANHANG
SELECT *FROM DONHANG
-- insert don hang	
INSERT INTO DonHang(ID_KhachHang, TongTien, TrangThaiDonHang, DiaChiGiaoHang,PhuongThucThanhToan)
VALUES
go 

-- insert chitietdonhang

go 
--don hang 
select d.ID_DonHang, k.hoten, k.DiaChi, k.SoDienThoai, d.NgayDatHang, d.TongTien, d.PhuongThucThanhToan  from donhang d join khachhang k on d.ID_KhachHang = k.ID_KhachHang


-- chi tiết đơn hàng
select ChiTietDonHang.ID_ChiTietDonHang, sanpham.TenSanPham, SanPham.Gia, ChiTietDonHang.SoLuong, sanpham.HinhAnh, ChiTietDonHang.SoLuong * SanPham.Gia as 'Tổng giá' from ChiTietDonHang join SanPham on ChiTietDonHang.ID_SanPham = sanpham.ID_SanPham where ID_DonHang = 4

select *from sanpham