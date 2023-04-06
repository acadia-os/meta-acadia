DESCRIPTION = "Custom recipe to set the hostname for the Yocto-based Linux system"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://hostname"

S = "${WORKDIR}"

do_install() {
    install -m 0644 ${S}/hostname ${D}${sysconfdir}/hostname
}

FILES_${PN} = "${sysconfdir}/hostname"

# Ensure the package is installed in the final image
IMAGE_INSTALL:append = " custom-hostname-prime"
