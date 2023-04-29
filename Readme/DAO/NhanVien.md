# Giới thiệu
Đây là một tập tin lớp Java có tên `DAO_NhanVien` chứa một số chức năng để tương tác với bảng `NhanVien` trong cơ sở dữ liệu. Lớp này thực hiện các thao tác như thêm một bản ghi nhân viên mới, lấy một nhân viên bằng số điện thoại hoặc ID và kiểm tra xem một nhân viên có phải là admin hay không.

# Các chức năng của lớp

### `public DAO_NhanVien()`
Đây là hàm khởi tạo cho lớp `DAO_NhanVien` để khởi tạo kết nối tới cơ sở dữ liệu.

### `public NhanVien timNhanVien(String sdt)`
Hàm này lấy một bản ghi nhân viên từ bảng `NhanVien` bằng số điện thoại của nhân viên. Hàm trả về một thể hiện của lớp `NhanVien` nếu bản ghi tồn tại, ngược lại nó trả về `null`.

### `public NhanVien timNhanVienAdmin(String sdt)`
Hàm này tương tự như `timNhanVien` nhưng chỉ trả về các nhân viên admin.

### `public NhanVien timNhanVienTheoMa(String ma)`
Hàm này lấy một bản ghi nhân viên từ bảng `NhanVien` bằng ID của nhân viên. Hàm trả về một thể hiện của lớp `NhanVien` nếu bản ghi tồn tại, ngược lại nó trả về `null`.

### `public int themNV(NhanVien nv) throws Exception`
Hàm này thêm một bản ghi nhân viên mới vào bảng `NhanVien`. Nếu bản ghi đã tồn tại (xác định bởi ID), hàm trả về `0`; ngược lại, nó chèn bản ghi và trả về `1`.

# Ghi chú khác
- Lớp này sử dụng `PreparedStatement` để tránh các lỗ hổng SQL injection.
- Lớp `ConnectDB` không được hiển thị ở đây, nhưng nó cung cấp kết nối tới cơ sở dữ liệu.
