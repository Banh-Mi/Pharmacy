# Giới thiệu
- Đây là một tập tin lớp Java có tên `DAO_NhanVien` chứa một số chức năng để tương tác với bảng `NhanVien` trong cơ sở dữ liệu. Lớp này thực hiện các thao tác như thêm một bản ghi nhân viên mới, lấy một nhân viên bằng số điện thoại hoặc ID và kiểm tra xem một nhân viên có phải là admin hay không.

## Các chức năng của lớp

### `public DAO_NhanVien()`
- Đây là hàm khởi tạo cho lớp `DAO_NhanVien` để khởi tạo kết nối tới cơ sở dữ liệu.

### `public NhanVien timNhanVien(String sdt)`
- Hàm này lấy một bản ghi nhân viên từ bảng `NhanVien` bằng số điện thoại của nhân viên. Hàm trả về một thể hiện của lớp `NhanVien` nếu bản ghi tồn tại, ngược lại nó trả về `null`.

### `public NhanVien timNhanVienAdmin(String sdt)`
- Hàm này tương tự như `timNhanVien` nhưng chỉ trả về các nhân viên admin.

### `public NhanVien timNhanVienTheoMa(String ma)`
- Hàm này lấy một bản ghi nhân viên từ bảng `NhanVien` bằng ID của nhân viên. Hàm trả về một thể hiện của lớp `NhanVien` nếu bản ghi tồn tại, ngược lại nó trả về `null`.

### `public int themNV(NhanVien nv) throws Exception`
- Hàm này thêm một bản ghi nhân viên mới vào bảng `NhanVien`. Nếu bản ghi đã tồn tại (xác định bởi ID), hàm trả về `0`; ngược lại, nó chèn bản ghi và trả về `1`.

### `capNhatNhanVienNghiLam(String ma)`
- Đặt trường `trang_thai_lam` của một nhân viên có `ma_nhan_vien` được chỉ định thành 0, cho biết nhân viên đó không còn làm việc nữa.

### `sinhMaTuDong()`
- Tạo ra một `ma_nhan_vien` mới cho một nhân viên mới. ID mới được xây dựng bằng cách nối chuỗi "NV" với một số gồm sáu chữ số, một hơn số lớn nhất hiện tại trong cơ sở dữ liệu.

### `capNhatAdmind(NhanVien nv)`
- Cập nhật thông tin của một nhân viên có cùng trường `so_dien_thoai` như `nv`. Thông tin mới được lấy từ đối tượng `NhanVien` `nv` được truyền vào làm đối số.

### `getDSNhanVien()`
- Trả về một ArrayList chứa tất cả nhân viên trong bảng `NhanVien`. Mỗi nhân viên được đại diện bằng một đối tượng `NhanVien`.

### `getMaVaTenNV()`
- Trả về một ArrayList chứa tất cả `ma_nhan_vien` và `ten_nhan_vien` (ID và tên nhân viên) của tất cả nhân viên.

### `dangNhap(String tk, String mk)`
- Kiểm tra xem một nhân viên với số điện thoại và mật khẩu được cung cấp có tồn tại trong cơ sở dữ liệu và có `trang_thai_lam` được đặt thành 1 (tức là vẫn đang làm việc) hay không. Nếu nhân viên tồn tại và mật khẩu đúng, trả về một đối tượng `NhanVien` đại diện cho nhân viên đó. Ngược lại, trả về null.

### `taoMaNgauNhienNhanVien()`
- Sinh một ID Nhân viên ngẫu nhiên. Phương thức này chọn ID Nhân viên mới nhất từ cơ sở dữ liệu và thêm 1 vào. Nếu ID hiện tại đã đạt đến giá trị tối đa (999999), nó sẽ tạo một ID mới bằng cách tăng phần chữ cái của ID. Ví dụ, nếu ID mới nhất là `NVYY999999`, ID tiếp theo sẽ là `NVZA000001`. Cuối cùng, phương thức trả về ID mới được tạo.

### `capnhapMatKhau(String mkNew, String soDTNV)` 
- Cập nhật mật khẩu cho một nhân viên với số điện thoại được cung cấp. Phương thức này thực hiện một truy vấn SQL để cập nhật cột `mat_khau` (mật khẩu) trong bảng `NhanVien`.

### `timNVTheoTenVaSdt(String ten, String sdt)`
- Tìm kiếm các nhân viên có tên hoặc số điện thoại khớp với chuỗi tìm kiếm được cung cấp. Phương thức này thực hiện một truy vấn SQL để chọn tất cả các dòng từ bảng `NhanVien` trong đó cột `ten_nhan_vien` (tên nhân viên) hoặc `so_dien_thoai` (số điện thoại) chứa các chuỗi tìm kiếm được cung cấp. Sau đó, phương thức tạo một đối tượng Nhân viên cho mỗi dòng và thêm nó vào một ArrayList, được trả về sau đó.
