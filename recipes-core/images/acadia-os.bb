SUMMARY = "Acadia core image "

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

IMAGE_LINGUAS = " "

LICENSE = "MIT"

inherit core-image

PACKAGE_INSTALL= "\
    base-files \
    base-passwd \
    busybox \
    htop \
    kiosk \
    initscripts \
    python3-flask \
    qtwebkit \
    chromium-x11 \
    ${ROOTFS_BOOTSTRAP_INSTALL} \
"

WKS_FILES = "acadia-os.wks"

IMAGE_ROOTFS_SIZE = "8192"
IMAGE_ROOTFS_EXTRA_SPACE = "4"