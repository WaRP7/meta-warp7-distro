FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
	file://hciattach.service \
"

inherit systemd

do_install_append() {
	install -d ${D}${systemd_unitdir}/system
	install -m 644 ${WORKDIR}/hciattach.service ${D}${systemd_unitdir}/system
}

SYSTEMD_SERVICE_${PN} = "hciattach.service"
