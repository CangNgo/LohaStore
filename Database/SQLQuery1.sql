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
