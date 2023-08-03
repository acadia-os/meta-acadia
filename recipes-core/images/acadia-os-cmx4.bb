SUMMARY = "An example of partitioned image."

SRC_URI = "file://${FILE_DIRNAME}/${BPN}.wks"

IMAGE_INSTALL += " \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-rpi-test \
    base-files \
    base-passwd \
    busybox \
    htop \
    can-utils canutils wpa-supplicant \
    openssh-sftp-server \
    psplash \
    initscripts \
    packagegroup-core-x11 \
    packagegroup-core-x11-base \
    packagegroup-core-x11-xserver \
    packagegroup-core-x11-sato \
    python3-flask \
    ntp \
    qtquick3d qtquickcontrols2 qtquicktimeline qtcharts qt5ledscreen qt5everywheredemo \
    ptpd \
    nodejs \
    chromium-x11 \
    kiosk \
    qt5everywheredemo  qtbase   qtdatavis3d \
    qt5ledscreen \
    libdnf \
    cmake \
    python3-pychromecast \
    xserver-xorg xinit xterm \
    packagegroup-core-ssh-openssh \
    packagegroup-core-buildessential\ 
    ${ROOTFS_BOOTSTRAP_INSTALL} \
"

IMAGE_FSTYPES = "wic"

WKS_FILE_DEPENDS = "dosfstools-native mtools-native gptfdisk-native  e2fsprogs-native"
WKS_FILE_DEPENDS:append:x86 = " syslinux-native syslinux"
WKS_FILE_DEPENDS:append:x86-64 = " syslinux-native syslinux"
WKS_FILE_DEPENDS:append:x86-x32 = " syslinux-native syslinux"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_ROOTFS_EXTRA_SPACE = "8000"

INIT_MANAGER = "systemd"
RASPBERRYPI_DISPLAY = "1"
DISTRO_FEATURES += "systemd x11"
IMAGE_INSTALL += " twm xterm xclock mtdev"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"
inherit image
    