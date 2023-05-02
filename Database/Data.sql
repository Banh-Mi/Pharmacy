exec sp_MSforeachtable "alter table ? nocheck constraint all"

exec sp_MSforeachtable "Delete from ?"

INSERT INTO [dbo].[CongDung] (ma_cong_dung, nhom_cong_dung, cong_dung)
VALUES
('CD001', 'A', N'Giảm đau'),
('CD002', 'B', N'Chống viêm'),
('CD003', 'C', N'Kích thích trí nhớ'),
('CD004', 'D', N'Tiêu viêm'),
('CD005', 'E', N'Giảm cholesterol'),
('CD006', 'F', N'Điều trị ho'),
('CD007', 'G', N'Chống co giật'),
('CD008', 'H', N'Lợi tiểu'),
('CD009', 'I', N'Kháng khuẩn'),
('CD010', 'J', N'Giảm đau bụng'),
('CD011', 'K', N'Giảm đau khớp'),
('CD012', 'L', N'Giảm sưng viêm'),
('CD013', N'M', N'Điều trị ung thư'),
('CD014', 'N', N'Chống oxy hóa'),
('CD015', 'O', N'Tăng cường miễn dịch'),
('CD016', 'P', N'Điều trị tiểu đường'),
('CD017', 'Q', N'Giảm đau tim mạch'),
('CD018', 'R', N'Tăng cường sức khỏe'),
('CD019', 'S', N'Chống đột quỵ'),
('CD020', 'T', N'Giảm căng thẳng');


INSERT INTO [dbo].[Thuoc] (ma_thuoc, ten_thuoc, gia_ban, don_vi_tinh, thanh_phan, quy_cach_dong_goi, dang_bao_che, ham_luong, cty_san_xuat, nuoc_san_xuat, trang_thai_kd, thue_vat, so_dk, ma_cong_dung, so_luong_ban_dau, han_su_dung)
VALUES
('TH001', 'Paracetamol', 15000, N'Viên', 'Paracetamol', N'Hộp 10 viên',  N'Viên nén bao phim', '500mg',  N'Việt Nam',  N'Việt Nam', 1, 0.1, 'A123', 'CD001', 100, '2023-05-31'),
('TH002', 'Ibuprofen', 20000, N'Viên', 'Ibuprofen', N'Hộp 10 viên',  N'Viên nén bao phim', '200mg', N'Mỹ', N'Mỹ', 1, 0.1, 'B456', 'CD002', 50, '2024-03-15'),
('TH003', 'Amoxicillin', 25000, N'Viên', 'Amoxicillin', N'Hộp 10 viên',  N'Viên nén bao phim', '500mg', 'Anh', 'Anh', 1, 0.1, 'C789', 'CD003', 80, '2023-09-30'),
('TH004', 'Loratadine', 18000, N'Viên', 'Loratadine', N'Hộp 10 viên',  N'Viên nén bao phim', '10mg', N'Đức', N'Đức', 1, 0.1, 'D101', 'CD004', 120, '2023-11-30'),
('TH005', 'Aspirin', 12000, N'Viên', 'Aspirin',  N'Hộp 10 viên',  N'Viên nén bao phim', '100mg', N'Pháp', N'Pháp', 1, 0.1, 'E112', 'CD005', 200, '2023-12-31'),
('TH006', 'Ciprofloxacin', 35000, N'Viên', 'Ciprofloxacin',  N'Hộp 10 viên',  N'Viên nén bao phim', '500mg', N'Đức', N'Đức', 1, 0.1, 'F223', 'CD005', 60, '2023-08-31'),
('TH007', 'Atenolol', 23000, N'Viên', 'Atenolol',  N'Hộp 10 viên',  N'Viên nén bao phim', '50mg', 'Anh', 'Anh', 1, 0.1, 'G334', 'CD006', 90, '2024-02-28'),
('TH008', 'Erythromycin', 28000, N'Viên', 'Erythromycin',  N'Hộp 10 viên',  N'Viên nén bao phim', '250mg', N'Pháp', N'Pháp', 1, 0.1, 'H445', 'CD007', 70, '2023-12-31'),
('TH009', 'Acetaminophen', 17000, N'Viên', 'Acetaminophen',  N'Hộp 10 viên',  N'Viên nén bao phim', '325mg', N'Mỹ', N'Mỹ', 1, 0.1, 'I556', 'CD008', 110, '2024-01-31'),
('TH010', 'Codeine', 30000, N'Viên', 'Codeine',  N'Hộp 10 viên',  N'Viên nén bao phim', '30mg',  N'Việt Nam',  N'Việt Nam', 1, 0.1, 'J667', 'CD009', 40, '2023-10-31'),
('TH011', 'Levofloxacin', 40000, N'Viên', 'Levofloxacin',  N'Hộp 10 viên',  N'Viên nén bao phim', '500mg', N'Đức', N'Đức', 1, 0.1, 'K778', 'CD010', 55, '2023-07-31'),
('TH012', N'Metronidazole', 21000, N'Viên', N'Metronidazole',  N'Hộp 10 viên',  N'Viên nén bao phim', '500mg', 'Anh', 'Anh', 1, 0.1, 'L889', 'CD011', 75, '2023-11-30'),
('TH013', 'Naproxen', 27000, N'Viên', 'Naproxen',  N'Hộp 10 viên',  N'Viên nén bao phim', '500mg', N'Mỹ', N'Mỹ', 1, 0.1, N'M900', 'CD012', 65, '2024-04-30'),
('TH014', 'Omeprazole', 35000, N'Viên', 'Omeprazole',  N'Hộp 10 viên',  N'Viên nén bao phim', '20mg', N'Pháp', N'Pháp', 1, 0.1, 'N011', 'CD013', 95, '2024-02-28'),
('TH015', 'Penicillin', 22000, N'Viên', 'Penicillin','Hộp 10 viên',  N'Viên nén bao phim', '500mg', N'Pháp', N'Pháp', 1, 0.1, N'M345', 'CD006', 60, '2023-10-31'),
('TH016', 'Omeprazole', 28000, N'Viên', 'Omeprazole',  N'Hộp 10 viên',  N'Viên nén bao phim', '20mg', 'Anh', 'Anh', 1, 0.1, 'N678', 'CD007', 90, '2024-06-30'),
('TH017', 'Losartan', 30000, N'Viên', 'Losartan',  N'Hộp 10 viên',  N'Viên nén bao phim', '50mg', N'Mỹ', N'Mỹ', 1, 0.1, 'O910', 'CD008', 70, '2023-08-31'),
('TH018', 'Folic Acid', 18000, N'Viên', 'Folic Acid',  N'Hộp 10 viên',  N'Viên nén bao phim', '1mg',  N'Việt Nam',  N'Việt Nam', 1, 0.1, 'P123', 'CD009', 150, '2023-09-30'),
('TH019', 'Levocetirizine', 24000, N'Viên', 'Levocetirizine',  N'Hộp 10 viên',  N'Viên nén bao phim', '5mg', N'Ấn Độ', N'Ấn Độ', 1, 0.1, 'Q456', 'CD010', 100, '2024-02-28'),
('TH020', 'Hydrochlorothiazide', 26000, N'Viên', 'Hydrochlorothiazide',  N'Hộp 10 viên',  N'Viên nén bao phim', '25mg', N'Mỹ', N'Mỹ', 1, 0.1, 'R789', 'CD011', 80, '2023-12-31');


INSERT INTO KhachHang (ma_khach_hang, ten_khach_hang, gioi_tinh, so_dien_thoai, dia_chi, trang_thai)
VALUES
('KH001', N'Nguyễn Văn A', 1, '0987654321', N'Hà Nội', 1),
('KH002', N'Trần Thị B', 0, '0912345678', N'TP HCM', 1),
('KH003', N'Lê Văn C', 1, '0965432187', N'Đà Nẵng', 1),
('KH004', N'Phạm Thị D', 0, '0908765432', N'Hải Phòng', 1),
('KH005', N'Hoàng Văn E', 1, '0912345678', N'Huế', 1),
('KH006', N'Nguyễn Thị F', 0, '0987654321', N'Hà Nội', 1),
('KH007', N'Trần Văn G', 1, '0965432187', N'TP HCM', 1),
('KH008', N'Lê Thị H', 0, '0908765432', N'Đà Nẵng', 1),
('KH009', N'Phạm Văn I', 1, '0912345678', N'Hải Phòng', 1),
('KH010', N'Hoàng Thị K', 0, '0987654321', N'Huế', 1),
('KH011', N'Nguyễn Văn L', 1, '0912345678', N'Hà Nội', 1),
('KH012', N'Trần Thị M', 0, '0965432187', 'TP HCM', 1),
('KH013', N'Lê Văn N', 1, '0908765432', N'Đà Nẵng', 1),
('KH014', N'Phạm Thị O', 0, '0912345678', N'Hải Phòng', 1),
('KH015', N'Hoàng Văn P', 1, '0987654321', N'Huế', 1),
('KH016', N'Nguyễn Thị Q', 0, '0912345678', N'Hà Nội', 1),
('KH017', N'Trần Văn R', 1, '0965432187', 'TP HCM', 1),
('KH018', N'Lê Thị S', 0, '0908765432', N'Đà Nẵng', 1),
('KH019', N'Phạm Văn T', 1, '0912345678', N'Hải Phòng', 1),
('KH020', N'Hoàng Thị U', 0, '0987654321', N'Huế', 1)


INSERT INTO NhanVien (ma_nhan_vien, ten_nhan_vien, gioi_tinh, so_dien_thoai, mat_khau, trang_thai_lam, loai_nhan_vien, so_cmnd, dia_chi)
VALUES
('NV001', N'Nguyễn Văn A', 1, '0356890123', 'abc123', 1, 0, '123456789', N'Hà Nội'),
('NV002', N'Trần Thị B', 0, '0798554667', 'xyz456', 1, 0, '987654321', N'Hồ Chí Minh'),
('NV003', N'Lê Văn C', 1, '0907778889', 'def789', 1, 1, '234567890', N'Đà Nẵng'),
('NV004', N'Hoàng Thị D', 0, '0834567890', 'uvw234', 1, 0, '345678901', N'Hải Phòng'),
('NV005', N'Nguyễn Thị E', 0, '0977778888', 'pqr567', 1, 1, '456789012', N'Huế')


exec sp_MSforeachtable "alter table ? check constraint all"
