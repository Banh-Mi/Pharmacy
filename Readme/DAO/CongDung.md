


## Giới thiệu

Đây là mã nguồn Java chứa các phương thức để truy vấn và thao tác dữ liệu từ bảng `CongDung` trong cơ sở dữ liệu. Nó bao gồm các phương thức để lấy danh sách công dụng và lấy thông tin của một công dụng dựa trên mã công dụng. Mã nguồn sử dụng các câu truy vấn SQL để tương tác với cơ sở dữ liệu.

## Phương thức

### `getListCongDung()`

Phương thức này trả về một danh sách `ArrayList` các đối tượng `CongDung` chứa thông tin về tất cả các công dụng trong bảng `CongDung`.

### `getCongDungByMaCongDung(String maCongDung)`

Phương thức này trả về một đối tượng `CongDung` chứa thông tin về một công dụng được xác định bởi mã công dụng `maCongDung`. Nó sử dụng câu truy vấn SQL để truy vấn thông tin từ cơ sở dữ liệu.
