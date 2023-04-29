# Giới thiệu

- Lớp này chứa các phương thức tương tác với bảng "KhachHang" trong cơ sở dữ liệu. Nó cung cấp các chức năng tìm kiếm, cập nhật và truy xuất đối tượng "KhachHang".

## Phương thức

* `timKhachHangTheoSDT(String so_dien_thoai): KhachHang`: tìm kiếm một khách hàng theo số điện thoại và trả về một đối tượng `KhachHang`.
* `timKhachHangTheoDK(String tenKH, String sdt, String trang_thai, String gioi_tinh, String dc): ArrayList<KhachHang>`: tìm kiếm khách hàng theo tiêu chí cho trước và trả về một `ArrayList` các đối tượng `KhachHang`.
* `getDsKhachHang(): ArrayList<KhachHang>`: truy xuất tất cả khách hàng từ cơ sở dữ liệu và trả về một `ArrayList` các đối tượng `KhachHang`.
* `getAllKhachHang(): ArrayList<KhachHang>`: truy xuất tất cả khách hàng từ cơ sở dữ liệu và trả về một `ArrayList` các đối tượng `KhachHang`.

## Sử dụng

```java
// tạo đối tượng DAO
DAO_KhachHang dao = new DAO_KhachHang();

// tìm kiếm một khách hàng theo số điện thoại
KhachHang kh = dao.timKhachHangTheoSDT("0123456789");

// tìm kiếm khách hàng theo tiêu chí cho trước
ArrayList<KhachHang> listKhachHang = dao.timKhachHangTheoDK("tenKH", "sdt", "trang_thai", "gioi_tinh", "dc");

// truy xuất tất cả khách hàng
ArrayList<KhachHang> listKhachHang = dao.getDsKhachHang();
ArrayList<KhachHang> listKhachHang = dao.getAllKhachHang();
```
