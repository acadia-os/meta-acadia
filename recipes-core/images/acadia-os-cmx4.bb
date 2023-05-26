SUMMARY = "An example of partitioned image."

SRC_URI = "file://${FILE_DIRNAME}/${BPN}.wks"

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-rpi-test \
    base-files \
    base-passwd \
    busybox \
    htop \
    openssh-sftp-server \
    psplash \
    initscripts \
    packagegroup-core-x11 \
    packagegroup-core-x11-base \
    packagegroup-core-x11-xserver \
    packagegroup-core-x11-sato \
    python3-flask \
    ntp \
    ptpd \
    xserver-xorg xinit xterm \
    packagegroup-core-ssh-openssh \
    ${ROOTFS_BOOTSTRAP_INSTALL} \
"

IMAGE_FSTYPES = "wic"

WKS_FILE_DEPENDS = "dosfstools-native mtools-native gptfdisk-native  e2fsprogs-native"
WKS_FILE_DEPENDS:append:x86 = " syslinux-native syslinux"
WKS_FILE_DEPENDS:append:x86-64 = " syslinux-native syslinux"
WKS_FILE_DEPENDS:append:x86-x32 = " syslinux-native syslinux"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_ROOTFS_EXTRA_SPACE = "8000"

DISTRO_FEATURES += "systemd"
DISTRO_FEATURES_BACKFILL_CONSIDERED += "sysvinit"
VIRTUAL-RUNTIME_init_manager = "systemd"
VIRTUAL-RUNTIME_initscripts = "systemd-compat-units"
INHERIT += "extrausers"
EXTRA_USERS_PARAMS = " useradd sandesh; \
                    useradd soccentric; \
                    usermod  -p 'sandesh' sandesh; \
                    usermod  -p 'soccentric' soccentric; \
                    usermod  -a -G sudo sandesh; \
                    usermod  -a -G sudo soccentric;"
inherit image
    