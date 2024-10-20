﻿-- Tạo database
CREATE DATABASE BANHANG;
GO
-- Sử dụng database vừa tạo
USE BANHANG;
GO
--Tạo bảng taikhoan
CREATE TABLE TAIKHOAN(
	ID INT PRIMARY KEY IDENTITY(1,1), 
	TAIKHOAN VARCHAR(30) NOT NULL, 
	MATKHAU VARCHAR(50) NOT NULL, 
	VAITRO BIT DEFAULT 1
);
GO
-- Tạo bảng KhachHang
CREATE TABLE KhachHang (
    ID_KhachHang INT PRIMARY KEY IDENTITY(1,1),
	ID_TAIKHOAN INT NOT NULL, 
    HoTen NVARCHAR(100) NOT NULL,
    Email VARCHAR(100) UNIQUE,
    SoDienThoai VARCHAR(20),
    DiaChi NVARCHAR(255),
    NgaySinh DATE,
    NgayDangKy DATETIME DEFAULT GETDATE(),
	FOREIGN KEY(ID_TAIKHOAN) REFERENCES TAIKHOAN (ID)
);
go
-- Tạo bảng LoaiSanPham
CREATE TABLE LoaiSanPham (
    ID_LoaiSanPham INT PRIMARY KEY IDENTITY(1,1),
    TenLoai NVARCHAR(100) NOT NULL,
    MoTa NVARCHAR(255)
);
go
-- Tạo bảng SanPham
CREATE TABLE SanPham (
    ID_SanPham INT PRIMARY KEY IDENTITY(1,1),
    ID_LoaiSanPham INT,
    TenSanPham NVARCHAR(100) NOT NULL,
    MoTa NVARCHAR(255),
    Gia DECIMAL(10, 2) NOT NULL,
    SoLuongTonKho INT NOT NULL,
    HinhAnh VARCHAR(255),
    FOREIGN KEY (ID_LoaiSanPham) REFERENCES LoaiSanPham(ID_LoaiSanPham)
);
go
-- Tạo bảng GioHang (đã sửa)
CREATE TABLE GioHang (
  ID_GioHang INT PRIMARY KEY IDENTITY(1,1),
  ID_KhachHang INT,
  NgayTao DATETIME DEFAULT GETDATE(),
  TrangThai NVARCHAR(50),
  FOREIGN KEY (ID_KhachHang) REFERENCES KhachHang(ID_KhachHang)
);
go
-- Tạo bảng ChiTietGioHang (đã sửa)
CREATE TABLE ChiTietGioHang (
  ID_ChiTietGioHang INT PRIMARY KEY IDENTITY(1,1),
  ID_GioHang INT,
  ID_SanPham INT,
  SoLuong INT NOT NULL,
  GiaTaiThoiDiemThem DECIMAL(10,2),
  FOREIGN KEY (ID_GioHang) REFERENCES GioHang(ID_GioHang),
  FOREIGN KEY (ID_SanPham) REFERENCES SanPham(ID_SanPham)
);
go
-- Tạo bảng DonHang
CREATE TABLE DonHang (
    ID_DonHang INT PRIMARY KEY IDENTITY(1,1),
    ID_KhachHang INT,
    NgayDatHang DATETIME DEFAULT GETDATE(),
    TongTien DECIMAL(10, 2) NOT NULL,
    TrangThaiDonHang NVARCHAR(50),
    DiaChiGiaoHang NVARCHAR(255),
    PhuongThucThanhToan NVARCHAR(100),
    FOREIGN KEY (ID_KhachHang) REFERENCES KhachHang(ID_KhachHang)
);
go
-- Tạo bảng ChiTietDonHang
CREATE TABLE ChiTietDonHang (
    ID_ChiTietDonHang INT PRIMARY KEY IDENTITY(1,1),
    ID_DonHang INT,
    ID_SanPham INT,
    SoLuong INT NOT NULL,
    GiaTaiThoiDiemMua DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (ID_DonHang) REFERENCES DonHang(ID_DonHang),
    FOREIGN KEY (ID_SanPham) REFERENCES SanPham(ID_SanPham)
);
GO

-- Insert dữ liệu vào bảng LoaiSanPham
INSERT INTO LoaiSanPham (TenLoai, MoTa)
VALUES 
('hoalen', N'Hoa làm từ len'),
('mockhoa', N'Móc khóa làm từ len');
GO
-- Insert dữ liệu vào bảng SanPham
INSERT INTO SanPham (ID_LoaiSanPham, TenSanPham, MoTa, Gia, SoLuongTonKho, HinhAnh)
VALUES 
-- Sản phẩm loại hoalen
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Cúc họa mi', N'Hoa cúc họa mi làm từ len', 50000, 100, 'cuchoami.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Hoa cúc', N'Hoa cúc làm từ len', 50000, 100, 'hoacuc.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Hoa đôi xanh', N'Hoa đôi xanh làm từ len', 50000, 100, 'hoadoixanh.png'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Hoa hồng', N'Hoa hồng làm từ len', 50000, 100, 'hoahong.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Hoa hồng nhỏ', N'Hoa hồng nhỏ làm từ len', 50000, 100, 'hoahongnho.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Hoa lưu ly', N'Hoa lưu ly làm từ len', 50000, 100, 'HOALUULY.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Hoa Tulip', N'Hoa Tulip làm từ len', 50000, 100, 'HOATLIPCANH.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Hoa hồng trắng', N'Hoa hồng trắng làm từ len', 50000, 100, 'hongtrang.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Hoa hướng dương', N'Hoa hướng dương làm từ len', 50000, 100, 'huongduong.webp'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Hoa Lavender', N'Hoa Lavender làm từ len', 50000, 100, 'lavender.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Hoa hồng ghép cạnh', N'Hoa hồng ghép cạnh làm từ len', 50000, 100, 'HOAHONGGHEPCANH.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Hoa Tulip có cánh', N'Hoa Tulip có cánh làm từ len', 50000, 100, 'HOATULIPCOCANH.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'hoalen'), N'Cành hoa nhỏ', N'Cành hoa nhỏ làm từ len', 50000, 100, 'sg-11134201-23020-sf0x8fu25env02.jpg')
GO
INSERT INTO SanPham (ID_LoaiSanPham, TenSanPham, MoTa, Gia, SoLuongTonKho, HinhAnh)
VALUES 
-- Sản phẩm loại mockhoa
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'mockhoa'), N'Bơ len', N'Móc khóa hình bơ làm từ len', 50000, 100, 'bo.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'mockhoa'), N'Móc khóa cá heo', N'Móc khóa hình cá heo làm từ len', 50000, 100, 'dangnhap.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'mockhoa'), N'Dưa hấu len', N'Móc khóa hình dưa hấu làm từ len', 50000, 100, 'duahau.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'mockhoa'), N'Heo len', N'Móc khóa hình heo làm từ len', 50000, 100, 'heo.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'mockhoa'), N'Móc treo hình hoa', N'Móc treo hình hoa làm từ len', 50000, 100, 'images.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'mockhoa'), N'Hoa hồng', N'Móc khóa hình hoa hồng làm từ len', 50000, 100, 'hoahong.jpg'),
((SELECT ID_LoaiSanPham FROM LoaiSanPham WHERE TenLoai = 'mockhoa'), N'Vịt len đội mũ', N'Móc khóa hình vịt đội mũ làm từ len', 50000, 100, 'VITLENDOIMU.jpg');
GO
-- Tạo khách hàng mẫu
-- Tạo bảng TAIKHOAN
CREATE TABLE TAIKHOAN(
    ID INT PRIMARY KEY IDENTITY(1,1), 
    TAIKHOAN VARCHAR(30) NOT NULL, 
    MATKHAU VARCHAR(50) NOT NULL, 
    VAITRO BIT DEFAULT 1
);
go
-- Insert dữ liệu vào bảng TAIKHOAN
INSERT INTO TAIKHOAN (TAIKHOAN, MATKHAU, VAITRO)
VALUES 
('nguyenvana', 'password123', 1),
('tranthib', 'password456', 1),
('levanc', 'password789', 1);
GO
-- Insert dữ liệu vào bảng KhachHang với ID_TAIKHOAN
INSERT INTO KhachHang (ID_TAIKHOAN, HoTen, Email, SoDienThoai, DiaChi)
VALUES 
(1, N'Nguyễn Văn A', 'nguyenvana@email.com', '0123456789', N'Hà Nội'),
(2, N'Trần Thị B', 'tranthib@email.com', '0987654321', N'Hồ Chí Minh'),
(3, N'Lê Văn C', 'levanc@email.com', '0369852147', N'Đà Nẵng');
GO
-- Tạo giỏ hàng và chi tiết giỏ hàng ngẫu nhiên
DECLARE @i INT = 1;
WHILE @i <= 5 -- Tạo 5 giỏ hàng
BEGIN
    DECLARE @KhachHangID INT = (SELECT TOP 1 ID_KhachHang FROM KhachHang ORDER BY NEWID());
    
    INSERT INTO GioHang (ID_KhachHang, NgayTao, TrangThai)
    VALUES (@KhachHangID, DATEADD(DAY, -RAND()*30, GETDATE()), N'Đang xử lý');
    
    DECLARE @GioHangID INT = SCOPE_IDENTITY();
    
    -- Thêm 1-3 sản phẩm vào giỏ hàng
    DECLARE @j INT = 1;
    WHILE @j <= RAND()*(3-1)+1
    BEGIN
        DECLARE @SanPhamID INT = (SELECT TOP 1 ID_SanPham FROM SanPham ORDER BY NEWID());
        DECLARE @SoLuong INT = RAND()*(5-1)+1;
        DECLARE @Gia DECIMAL(10,2) = (SELECT Gia FROM SanPham WHERE ID_SanPham = @SanPhamID);
        
        INSERT INTO ChiTietGioHang (ID_GioHang, ID_SanPham, SoLuong, GiaTaiThoiDiemThem)
        VALUES (@GioHangID, @SanPhamID, @SoLuong, @Gia);
        
        SET @j = @j + 1;
    END
    
    SET @i = @i + 1;
END
GO
-- Tạo đơn hàng và chi tiết đơn hàng ngẫu nhiên
DECLARE @i INT = 1;
SET @i = 1;
WHILE @i <= 10 -- Tạo 10 đơn hàng
BEGIN
    DECLARE @KhachHangID INT = (SELECT TOP 1 ID_KhachHang FROM KhachHang ORDER BY NEWID());
    DECLARE @TongTien DECIMAL(10,2) = 0;
    
    INSERT INTO DonHang (ID_KhachHang, NgayDatHang, TongTien, TrangThaiDonHang, DiaChiGiaoHang, PhuongThucThanhToan)
    VALUES (@KhachHangID, DATEADD(DAY, -RAND()*30, GETDATE()), 0, N'Đã đặt hàng', N'Địa chỉ giao hàng mẫu', N'Thanh toán khi nhận hàng');
    
    DECLARE @DonHangID INT = SCOPE_IDENTITY();
    
    -- Thêm 1-5 sản phẩm vào đơn hàng
	  DECLARE @j INT = 1;
    SET @j = 1;
    WHILE @j <= RAND()*(5-1)+1
    BEGIN
        DECLARE @SanPhamID INT = (SELECT TOP 1 ID_SanPham FROM SanPham ORDER BY NEWID());
        DECLARE @SoLuong INT = RAND()*(5-1)+1;
        DECLARE @Gia DECIMAL(10,2) = (SELECT Gia FROM SanPham WHERE ID_SanPham = @SanPhamID);
        
        INSERT INTO ChiTietDonHang (ID_DonHang, ID_SanPham, SoLuong, GiaTaiThoiDiemMua)
        VALUES (@DonHangID, @SanPhamID, @SoLuong, @Gia);
        
        SET @TongTien = @TongTien + (@Gia * @SoLuong);
        
        SET @j = @j + 1;
    END
    
    -- Cập nhật tổng tiền đơn hàng
    UPDATE DonHang SET TongTien = @TongTien WHERE ID_DonHang = @DonHangID;
    
    SET @i = @i + 1;
END
GO

-- Bước 1: Thêm một giỏ hàng mới cho khách hàng có ID = 2
INSERT INTO GioHang (ID_KhachHang, NgayTao, TrangThai)
VALUES (2, GETDATE(), 'Đang xử lý');

-- Bước 2: Lấy ID của giỏ hàng vừa tạo
DECLARE @GioHangID INT = SCOPE_IDENTITY();

-- Bước 3: Thêm các sản phẩm vào giỏ hàng
INSERT INTO ChiTietGioHang (ID_GioHang, ID_SanPham, SoLuong, GiaTaiThoiDiemThem)
VALUES
    (@GioHangID, 1, 2, (SELECT Gia FROM SanPham WHERE ID_SanPham = 1)),
    (@GioHangID, 3, 1, (SELECT Gia FROM SanPham WHERE ID_SanPham = 3));


	
EXEC SP_InsertUser	'cangliengglien', 'cangngoollieoođàdfo12', 'cangliehgnlien', 'Ngô Tấn Cang'
GO
CREATE OR ALTER PROC SP_InsertUser 
    @tenDangnhap VARCHAR(100), 
    @email VARCHAR(100), 
    @matkhau VARCHAR(100),
    @hoten NVARCHAR(100)
AS 
BEGIN
    BEGIN TRY
        BEGIN TRANSACTION

        -- Chèn vào bảng TAIKHOAN
        INSERT INTO TAIKHOAN(TAIKHOAN, MATKHAU, VAITRO)
        VALUES (@tenDangnhap, @matkhau, 0)  -- 0 thay cho 'user' nếu VAITRO là BIT

        -- Lấy ID của TAIKHOAN vừa chèn
        DECLARE @idTaiKhoan INT = SCOPE_IDENTITY();

        -- Chèn vào bảng KhachHang
        INSERT INTO KhachHang(ID_TAIKHOAN, HoTen, Email)
        VALUES (@idTaiKhoan, @hoten, @email)

        -- Lấy ID của KhachHang vừa chèn
        DECLARE @idKhachhang INT = SCOPE_IDENTITY();

        -- Chèn vào bảng GioHang
        INSERT INTO GioHang(ID_KhachHang, NgayTao)
        VALUES (@idKhachhang, GETDATE())

        -- Nếu mọi thứ đều thành công, commit transaction
        COMMIT TRANSACTION
    END TRY
    BEGIN CATCH
        -- Nếu có lỗi, rollback transaction
        ROLLBACK TRANSACTION
      
    END CATCH
END

use banhang

SELECT * FROM KHACHHANG WHERE Hoten = N'Ngô Tấn Cang'
go 


select * from SanPham join LoaiSanPham on SanPham.ID_LoaiSanPham = LoaiSanPham.ID_LoaiSanPham where LoaiSanPham.TenLoai = 'hoalen'
 
select count(taikhoan) from taikhoan where taikhoan = 'canglien'

select *from TAIKHOAN

select *from khachhang 

select *from donhang

select * from SanPham