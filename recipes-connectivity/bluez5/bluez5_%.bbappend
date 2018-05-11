FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
	file://hciattach.service \
"

inherit systemd

do_install_append() {
	install -Dm 644 ${WORKDIR}/hciattach.service ${D}${systemd_unitdir}/system/hciattach.service
}

SYSTEMD_SERVICE_${PN}_append_imx7s-warp = " hciattach.service"
