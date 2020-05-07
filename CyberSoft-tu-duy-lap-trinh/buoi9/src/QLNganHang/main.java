package QLNganHang;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		// đầu vào
		Scanner sn = new Scanner(System.in);
		DanhSachTaiKhoan ListTK = new DanhSachTaiKhoan();
		// xử lý
		do {
			System.out.println();
			System.out.println("1. Nhập thông tin Tài khoản ");
			System.out.println();
			System.out.println("2. xuất danh sách thông tin tài khoản ");
			System.out.println();
			System.out.println("3. Nạp tiền vào tài khoản ");
			System.out.println();
			System.out.println("4. Rút tiền ra tài khoản ");
			System.out.println();
			System.out.println("5. Chuyển khoản ");
			System.out.println();
			System.out.println("0. thoát ");
			System.out.println();
			System.out.print("lựa chọn của bạn : ");
			int luachon = Integer.parseInt(sn.nextLine());
			System.out.println();
			switch (luachon) {
			case 1: {
				System.out.println();
				System.out.println("1. Nhập thông tin Tài khoản ");
				ListTK.nhapDSTK();
				System.out.println("thành công ");
				break;
			}
			case 2: {
				System.out.println();
				System.out.println("2. xuất danh sách thông tin tài khoản ");
				System.out.println();
				ListTK.xuatDSTK();
				break;
			}
			case 3: {
				System.out.println();
				System.out.println("3. Nạp tiền vào tài khoản ");
				System.out.println();
				TaiKhoan tk = new TaiKhoan();
				if (ListTK.kiemTraTaiKhoan(tk, "cần nạp ")) {
					System.out.println("----tài khoản----");
					tk.xuat();
					System.out.println();
					System.out.println("số tiền cần Nạp :");
					double stn = Double.parseDouble(sn.nextLine());
					System.out.println(" nạp tiền thành công ");
					tk.napTien(stn);
					tk.xuat();
					ListTK.CapnhatDanhSach(tk);
				} else {
					System.out.println("không tồn tại tài khoản này ");
				}
				break;
			}
			case 4: {
				System.out.println();
				System.out.println("4. Rút tiền ra tài khoản ");
				System.out.println();
				TaiKhoan tk = new TaiKhoan();
				if (ListTK.kiemTraTaiKhoan(tk, "cần rút ")) {
					System.out.println("----tài khoản----");
					tk.xuat();
					System.out.println();
					while(true) {
					System.out.println("số tiền cần Rút :");
					double str = Double.parseDouble(sn.nextLine());
					System.out.println();
					if (tk.rutTien(str)) {
						System.out.println("----tài khoản còn ----");
						tk.xuat();
						ListTK.CapnhatDanhSach(tk);
						break;
					} else {
						System.out.println();
						System.out.println("tình trạng : that bai");
						System.out.println("vui lòng nhập lại số tiền cần rút");
						System.out.println();
					}
					}
				} else {
					System.out.println("không tồn tại tài khoản này ");
				}
				break;
			}
			case 5: {
				System.out.println();
				System.out.println("5. Chuyển khoản ");
				System.out.println();
				TaiKhoan tk = new TaiKhoan();
				if (ListTK.kiemTraTaiKhoan(tk, "chuyển ")) {
					System.out.println("----tài khoản----");
					tk.xuat();
					System.out.println();
					TaiKhoan tk2 = new TaiKhoan();
					if (ListTK.kiemTraTaiKhoan(tk2, "tài khoản nhận ")) {
						while(true) {
						System.out.println("nhập số tiền cần chuyển :");
						double soTienChuyen = Double.parseDouble(sn.nextLine());
						if (tk.chuyenKhoan(tk2, soTienChuyen)) {
							System.out.println("----tài khoản còn ----");
							tk.xuat();
							ListTK.CapnhatDanhSach(tk);
							ListTK.CapnhatDanhSach(tk2);
							break;
						} else {
							System.out.println();
							System.out.println("tình trạng : that bai");
							System.out.println("vui lòng nhập lại số tiền cần chuyển");
							System.out.println("---------------------------");
						}
						}
					} else {
						System.out.println("không tồn tại tài khoản này ");
					}
				} else {
					System.out.println("không tồn tại tài khoản này ");
				}
				break;
			}
			case 0: {
				System.out.println(" cảm ơn đã sử dụng ");
				break;
			}
			default: {
				System.out.println();
				System.out.println("vui lòng lựa chọn 1- 5 lựa chọn trên");
				break;
			}
			}

			if (luachon == 0) {
				break;
			} else {
				System.out.println();
				System.out.println("-------------------------------------------");
				System.out.println("----vui lòng nhấn phím enter để tiếp tục---");
				System.out.println("-------------------------------------------");
				sn.nextLine();

			}

		} while (true);
	}

}
