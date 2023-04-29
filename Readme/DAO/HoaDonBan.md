# Giới thiệu

- Đây là một lớp DAO để xử lý việc truy cập dữ liệu cho đối tượng `HoaDonBan` trong một ứng dụng Java Swing.

## Hàm tạo
- `public DAO_HoaDonBan()` - Hàm tạo của lớp, khởi tạo kết nối cơ sở dữ liệu.

## Phương thức taoMaNgauNhien()
- `public String taoMaNgauNhien()` - Tạo một ID ngẫu nhiên cho `HoaDonBan`. Phương thức lấy `ma_hoa_don_ban` mới nhất từ bảng `HoaDonBan` và tăng phần số của ID lên một. Nếu phần số đạt đến 999, phần chữ cái của ID sẽ được tăng lên tương ứng.

## Phương thức taoHoaDon(HoaDonBan hoaDon)
- `public boolean taoHoaDon(HoaDonBan hoaDon)` - Thêm một `HoaDonBan` mới vào bảng `HoaDonBan` trong cơ sở dữ liệu. Phương thức lấy một đối tượng `HoaDonBan` làm tham số và chèn dữ liệu của nó vào bảng.

## Phương thức getDSHoaDonBan()
- `public ArrayList<HoaDonBan> getDSHoaDonBan()` - Trả về một `ArrayList` chứa tất cả các đối tượng `HoaDonBan` trong bảng `HoaDonBan` của cơ sở dữ liệu. Phương thức lấy dữ liệu từ bảng, tạo một đối tượng `HoaDonBan` mới cho mỗi hàng và thêm nó vào `ArrayList`.
