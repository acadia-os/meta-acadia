SUMMARY = "An example of partitioned image."

SRC_URI = "file://${FILE_DIRNAME}/${BPN}.wks"

IMAGE_INSTALL = " \
    packagegroup-core-boot \
    packagegroup-core-full-cmdline \
    packagegroup-rpi-test \
    packagegroup-core-x11-sato \
    base-files \
    base-passwd \
    busybox \
    htop \
    qt5-plugin-generic-vboxtouch \
    openssh-sftp-server \
    psplash \
    initscripts \
    python3-flask \
    qtwebkit \
    qtmqtt \
    chromium-x11 \
    packagegroup-core-x11-xserver \
    packagegroup-core-ssh-openssh \
    packagegroup-core-x11 \
    packagegroup-core-x11-base \
    ${ROOTFS_BOOTSTRAP_INSTALL} \
"

IMAGE_FSTYPES = "wic"

WKS_FILE_DEPENDS = "dosfstools-native mtools-native gptfdisk-native  e2fsprogs-native"
WKS_FILE_DEPENDS:append:x86 = " syslinux-native syslinux"
WKS_FILE_DEPENDS:append:x86-64 = " syslinux-native syslinux"
WKS_FILE_DEPENDS:append:x86-x32 = " syslinux-native syslinux"

LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_ROOTFS_EXTRA_SPACE = "4000"

inherit image
