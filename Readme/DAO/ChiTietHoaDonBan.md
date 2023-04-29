# Giới thiệu

Đoạn mã này là một bộ sưu tập các phương thức để thao tác dữ liệu từ bảng `CT_HoaDonBan` trong một cơ sở dữ liệu. Nó chứa các phương thức để cập nhật và truy xuất thông tin, chẳng hạn như chèn một bản ghi mới, xóa một bản ghi bằng ID của nó và truy xuất thông tin về một bản ghi dựa trên ID của nó. Mã được viết bằng Java và sử dụng các truy vấn SQL để tương tác với cơ sở dữ liệu.

## Phương thức

### `capNhatChiTietHoaDon(Thuoc thuoc, String maHoaDon)`

Phương thức này chèn một bản ghi mới vào bảng `CT_HoaDonBan` với các giá trị được chỉ định cho các trường `so_luong`, `ma_thuoc`, `ma_hoa_don_ban`, `gia_ban` và `thue_vat`. Nó lấy hai tham số: một đối tượng `Thuoc` và một `String` đại diện cho ID của bản ghi cha trong bảng `HoaDonBan`.

### `xoaCTHoaDon(String maHD)`

Phương thức này xóa tất cả các bản ghi từ bảng `CT_HoaDonBan` có giá trị trường `ma_hoa_don_ban` trùng với tham số `maHD` được chỉ định. Nó trả về một giá trị boolean cho biết liệu việc xóa đã thành công hay không.

### `giaTienTheoMaHD(String maHD)`

Phương thức này tính toán và trả về tổng giá của tất cả các bản ghi trong bảng `CT_HoaDonBan` có giá trị trường `ma_hoa_don_ban` trùng với tham số `maHD` được chỉ định. Nó sử dụng một truy vấn SQL để thực hiện tính toán.

### `getChiTietHoaDon(String maHD)`

Phương thức này truy xuất thông tin về tất cả các bản ghi trong bảng `CT_HoaDonBan` có giá trị trường `ma_hoa_don_ban` trùng với tham số `maHD` được chỉ định. Nó trả về một `ArrayList` các đối tượng `CT_HoaDonBan`.

### `getDSCT_HdByMaHD(String maHD)`

Phương thức này truy xuất thông tin về tất cả các bản ghi trong bảng `CT_HoaDonBan` có giá trị trường `ma_hoa_don_ban` trùng với tham số `maHD` được chỉ định. Nó trả về một `ArrayList` các đối tượng `CT_HoaDonBan`.
