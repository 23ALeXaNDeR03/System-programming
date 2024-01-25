Name: countfiles
Version: 1.0
Release: 1%{?dist}
Summary: Script to count files in /etc directory
Requires: unzip

License: MIT
URL: https://github.com/23ALeXaNDeR03/system_programming
Source0: https://github.com/23ALeXaNDeR03/system_programming/archive/main.zip

BuildArch: noarch

%description
This package contains a script to count files in /etc directory

%prep
unzip %SOURCE0
cd system_programming-main/

%install
mkdir -p %{buildroot}/usr/bin
install -m 755 %{_builddir}/system_programming-main/count_files.sh %{buildroot}/usr/bin/count_files

%files
/usr/bin/count_files

%changelog
* Wed Jan 24 2024 Alexander Kuznetsov <al.kuznetsov.16@gmail.com> - 1.0-1
- Initial build
