create database QLThuoc

CREATE TABLE Thuoc (
  ma_thuoc VARCHAR(255) NOT NULL PRIMARY KEY,
  ten_thuoc VARCHAR(255) NOT NULL,
  gia_ban FLOAT NOT NULL,
  don_vi_tinh VARCHAR(255) NOT NULL,
  thanh_phan VARCHAR(255) NOT NULL,
  quy_cach_dong_goi VARCHAR(255) NOT NULL,
  dang_bao_che VARCHAR(255) NOT NULL,
  ham_luong VARCHAR(255) NOT NULL,
  cty_san_xuat VARCHAR(255) NOT NULL,
  nuoc_san_xuat VARCHAR(255) NOT NULL,
  trang_thai_kd int NOT NULL,
  thue_vat FLOAT NOT NULL,
  so_dk VARCHAR(255) NOT NULL,
  cong_dung VARCHAR(255) NOT NULL,
  so_luong_ban_dau BIGINT NOT NULL,
  han_su_dung DATE NOT NULL
);

CREATE TABLE CongDung (
  ma_cong_dung VARCHAR(255) NOT NULL PRIMARY KEY,
  nhom_cong_dung VARCHAR(255),
  cong_dung VARCHAR(255) NOT NULL
)

CREATE TABLE NhanVien (
  ma_nhan_vien VARCHAR(255) NOT NULL PRIMARY KEY,
  ten_nhan_vien VARCHAR(255) NOT NULL,
  gioi_tinh int NOT NULL,
  so_dien_thoai VARCHAR(255) NOT NULL,
  mat_khau VARCHAR(255) NOT NULL,
  trang_thai_lam int NOT NULL,
  loai_nhan_vien int NOT NULL,
  so_cmnd VARCHAR(255) NOT NULL,
  dia_chi VARCHAR(255) NOT NULL
);

CREATE TABLE KhachHang (
  ma_khach_hang VARCHAR(255) NOT NULL  PRIMARY KEY,
  ten_khach_hang VARCHAR(255) NOT NULL,
  gioi_tinh int NOT NULL,
  so_dien_thoai VARCHAR(255) NOT NULL,
  dia_chi VARCHAR(255) NOT NULL,
  trang_thai int NOT NULL
);

CREATE TABLE DiaChi (
  ma_dia_chi VARCHAR(255) NOT NULL PRIMARY KEY,
  tinh_tp VARCHAR(255) NOT NULL,
  quan_huyen VARCHAR(255) NOT NULL,
  phuong_xa VARCHAR(255) NOT NULL
);

CREATE TABLE HoaDonBan (
  ma_hoa_don_ban VARCHAR(255) NOT NULL  PRIMARY KEY,
  ngay_lap_hd DATE NOT NULL,
  ma_nhan_vien VARCHAR(255) NOT NULL,
  ma_khach_hang VARCHAR(255) NOT NULL,
  FOREIGN KEY (ma_nhan_vien) REFERENCES NhanVien(ma_nhan_vien),
  FOREIGN KEY (ma_khach_hang) REFERENCES KhachHang(ma_khach_hang)
);



ALTER TABLE NhanVien ADD FOREIGN KEY (dia_chi) REFERENCES DiaChi(ma_dia_chi);


ALTER TABLE KhachHang ADD FOREIGN KEY (dia_chi) REFERENCES DiaChi(ma_dia_chi);

CREATE TABLE CT_HoaDonBan (
  soLuong INT NOT NULL,
  giaBan float NOT NULL,
  thuocId VARCHAR(255) NOT NULL,
  hoaDonBanId VARCHAR(255) NOT NULL,
  vat FLOAT NOT NULL,
  FOREIGN KEY (thuocId) REFERENCES Thuoc(ma_thuoc),
  FOREIGN KEY (hoaDonBanId) REFERENCES HoaDonBan(ma_hoa_don_ban)
);


INSERT INTO CongDung (ma_cong_dung, nhom_cong_dung, cong_dung) 
VALUES 
('CD001', 'Nhóm A', 'Chống viêm'),
('CD002', 'Nhóm B', 'Giảm đau'),
('CD003', 'Nhóm C', 'Làm giảm sốt')


INSERT INTO thuoc (ma_thuoc, ten_thuoc, gia_ban, don_vi_tinh, thanh_phan, quy_cach_dong_goi, dang_bao_che, ham_luong, cty_san_xuat, nuoc_san_xuat, trang_thai_kd, thue_vat, so_dk, cong_dung, so_luong_ban_dau, han_su_dung) 
VALUES 
('TH001', 'Paracetamol 500mg', 15000, 'Viên', 'Paracetamol', 'Hộp 10 viên', 'Viên nén', '500mg/viên', 'CTY A', 'Việt Nam', 1, 10, 'ABC-123', 'CD001', 1000, '2024-03-01'),
('TH002', 'Ibuprofen 200mg', 20000, 'Viên', 'Ibuprofen', 'Hộp 20 viên', 'Viên nén', '200mg/viên', 'CTY B', 'Việt Nam', 1, 10, 'XYZ-789', 'CD002', 500, '2023-12-31'),
('TH003', 'Aspirin 100mg', 10000, 'Viên', 'Aspirin', 'Hộp 30 viên', 'Viên nén', '100mg/viên', 'CTY C', 'Việt Nam', 1, 10, 'PQR-456', 'CD002', 200, '2023-11-30')


INSERT INTO DiaChi (ma_dia_chi, tinh_tp, quan_huyen, phuong_xa) 
VALUES 
('DC001', 'Hà Nội', 'Hoàn Kiếm', 'Tràng Tiền'),
('DC002', 'Hà Nội', 'Ba Đình', 'Ngọc Hà'),
('DC003', 'Hà Nội', 'Tây Hồ', 'Nhật Tân'),
('DC004', 'Hà Nội', 'Đống Đa', 'Láng Thượng'),
('DC005', 'Hà Nội', 'Cầu Giấy', 'Dịch Vọng')

INSERT INTO NhanVien (ma_nhan_vien, ten_nhan_vien, gioi_tinh, so_dien_thoai, mat_khau, trang_thai_lam, loai_nhan_vien, so_cmnd, dia_chi) 
VALUES 
('NV001', 'Nguyễn Văn A', 1, '0901234567', 'password123', 1, 1, '123456789', 'DC001'),
('NV002', 'Trần Thị B', 0, '0909876543', 'password456', 1, 2, '234567890', 'DC002'),
('NV003', 'Lê Văn C', 1, '0911111111', 'password789', 1, 1, '345678901', 'DC003'),
('NV004', 'Phạm Thị D', 0, '0902222222', 'passwordabc', 1, 2, '456789012', 'DC004')


INSERT INTO KhachHang (ma_khach_hang, ten_khach_hang, gioi_tinh, so_dien_thoai, dia_chi, trang_thai)
VALUES
('KH001', 'Nguyễn Văn A', 1, '0987654321', 'DC001', 1),
('KH002', 'Trần Thị B', 0, '0123456789', 'DC002', 1),
('KH003', 'Lê Văn C', 1, '0909090909', 'DC003', 0);

INSERT INTO HoaDonBan (ma_hoa_don_ban, ngay_lap_hd, ma_nhan_vien, ma_khach_hang)
VALUES
('HDB001', '2023-04-01', 'NV001', 'KH001'),
('HDB002', '2023-04-02', 'NV002', 'KH002'),
('HDB003', '2023-04-03', 'NV003', 'KH003');

INSERT INTO CT_HoaDonBan (soLuong, giaBan, thuocId, hoaDonBanId, vat)
VALUES
(2, 10000, 'TH001', 'HDB001', 0.1),
(1, 5000, 'TH002', 'HDB001', 0.05),
(3, 15000, 'TH003', 'HDB002', 0.1);

SELECT ma_dia_chi, tinh_tp, quan_huyen, phuong_xa FROM [dbo].[DiaChi]
select ma_nhan_vien, ten_nhan_vien, gioi_tinh, so_dien_thoai, mat_khau, trang_thai_lam, loai_nhan_vien, so_cmnd, dia_chi
from [dbo].[NhanVien]

INSERT INTO [dbo].[NhanVien] (ma_nhan_vien, ten_nhan_vien, gioi_tinh, so_dien_thoai, mat_khau, trang_thai_lam, loai_nhan_vien, so_cmnd, dia_chi)
VALUES

CREATE TABLE LichSuDangNhap (
  thoiGianDangNhap DATETIME,
  maNV VARCHAR(255),
  FOREIGN KEY (maNV) REFERENCES NhanVien(ma_nhan_vien),
  tenNhanVien NVARCHAR(50),
  gioiTinh int ,
  soDienThoaiNV VARCHAR(20),
  loaiNV int
);