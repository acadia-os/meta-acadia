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
    initscripts \
    ${ROOTFS_BOOTSTRAP_INSTALL} \
"

WKS_FILES ?= "acadia-os-cmx4.wks"