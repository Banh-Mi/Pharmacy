USE [QLThuoc]
GO
/****** Object:  Table [dbo].[CongDung]    Script Date: 02/05/2023 11:35:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CongDung](
	[ma_cong_dung] [varchar](255) NOT NULL,
	[nhom_cong_dung] [nvarchar](255) NULL,
	[cong_dung] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_cong_dung] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[CT_HoaDonBan]    Script Date: 02/05/2023 11:35:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CT_HoaDonBan](
	[so_luong] [int] NOT NULL,
	[gia_ban] [float] NOT NULL,
	[ma_thuoc] [varchar](255) NOT NULL,
	[ma_hoa_don_ban] [varchar](255) NOT NULL,
	[thue_vat] [float] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDonBan]    Script Date: 02/05/2023 11:35:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDonBan](
	[ma_hoa_don_ban] [varchar](255) NOT NULL,
	[ngay_lap_hd] [date] NOT NULL,
	[ma_nhan_vien] [varchar](255) NOT NULL,
	[ma_khach_hang] [varchar](255) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_hoa_don_ban] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 02/05/2023 11:35:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[ma_khach_hang] [varchar](255) NOT NULL,
	[ten_khach_hang] [nvarchar](255) NULL,
	[gioi_tinh] [int] NOT NULL,
	[so_dien_thoai] [varchar](255) NOT NULL,
	[dia_chi] [nvarchar](255) NULL,
	[trang_thai] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_khach_hang] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LichSuDangNhap]    Script Date: 02/05/2023 11:35:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LichSuDangNhap](
	[tg_dang_nhap] [datetime] NULL,
	[ma_nhan_vien] [varchar](255) NULL,
	[ten_nhan_vien] [nvarchar](50) NULL,
	[gioi_tinh] [int] NULL,
	[so_dien_thoai] [varchar](20) NULL,
	[loai_nhan_vien] [int] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 02/05/2023 11:35:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[ma_nhan_vien] [varchar](255) NOT NULL,
	[ten_nhan_vien] [nvarchar](255) NULL,
	[gioi_tinh] [int] NOT NULL,
	[so_dien_thoai] [varchar](255) NOT NULL,
	[mat_khau] [varchar](255) NOT NULL,
	[trang_thai_lam] [int] NOT NULL,
	[loai_nhan_vien] [int] NOT NULL,
	[so_cmnd] [varchar](255) NOT NULL,
	[dia_chi] [nvarchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_nhan_vien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Thuoc]    Script Date: 02/05/2023 11:35:27 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Thuoc](
	[ma_thuoc] [varchar](255) NOT NULL,
	[ten_thuoc] [nvarchar](255) NULL,
	[gia_ban] [float] NOT NULL,
	[don_vi_tinh] [nvarchar](255) NULL,
	[thanh_phan] [nvarchar](255) NULL,
	[quy_cach_dong_goi] [nvarchar](255) NULL,
	[dang_bao_che] [nvarchar](255) NULL,
	[ham_luong] [nvarchar](255) NULL,
	[cty_san_xuat] [nvarchar](255) NULL,
	[nuoc_san_xuat] [nvarchar](255) NULL,
	[trang_thai_kd] [int] NOT NULL,
	[thue_vat] [float] NOT NULL,
	[so_dk] [varchar](255) NOT NULL,
	[ma_cong_dung] [varchar](255) NOT NULL,
	[so_luong_ban_dau] [bigint] NOT NULL,
	[han_su_dung] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ma_thuoc] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CT_HoaDonBan]  WITH CHECK ADD FOREIGN KEY([ma_hoa_don_ban])
REFERENCES [dbo].[HoaDonBan] ([ma_hoa_don_ban])
GO
ALTER TABLE [dbo].[CT_HoaDonBan]  WITH CHECK ADD FOREIGN KEY([ma_thuoc])
REFERENCES [dbo].[Thuoc] ([ma_thuoc])
GO
ALTER TABLE [dbo].[HoaDonBan]  WITH CHECK ADD FOREIGN KEY([ma_khach_hang])
REFERENCES [dbo].[KhachHang] ([ma_khach_hang])
GO
ALTER TABLE [dbo].[HoaDonBan]  WITH CHECK ADD FOREIGN KEY([ma_nhan_vien])
REFERENCES [dbo].[NhanVien] ([ma_nhan_vien])
GO
ALTER TABLE [dbo].[LichSuDangNhap]  WITH CHECK ADD FOREIGN KEY([ma_nhan_vien])
REFERENCES [dbo].[NhanVien] ([ma_nhan_vien])
GO
ALTER TABLE [dbo].[Thuoc]  WITH CHECK ADD  CONSTRAINT [FK_Thuoc_CongDung] FOREIGN KEY([ma_cong_dung])
REFERENCES [dbo].[CongDung] ([ma_cong_dung])
GO
ALTER TABLE [dbo].[Thuoc] CHECK CONSTRAINT [FK_Thuoc_CongDung]
GO
