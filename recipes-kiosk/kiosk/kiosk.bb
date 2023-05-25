DESCRIPTION = "Install kiosk.service"
LICENSE = "CLOSED"

SRC_URI = " \
    file://kiosk.service \
"

S = "${WORKDIR}"

do_install() {
    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/kiosk.service ${D}${systemd_unitdir}/system/
}

inherit allarch systemd

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "kiosk.service"
