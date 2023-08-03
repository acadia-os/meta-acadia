DESCRIPTION = "Install kiosk.service"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " file://kiosk.service "

S = "${WORKDIR}"


SYSTEMD_SERVICE_${PN} = "kiosk.service"

do_install:append() {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${S}/kiosk.service ${D}${systemd_unitdir}/system/kiosk.service
}

FILES:${PN} += " ${systemd_unitdir}/ \
                ${systemd_unitdir}/system/ \
                ${systemd_unitdir}/system/kiosk.service \
             "
SYSTEMD_AUTO_ENABLE = "enable"
