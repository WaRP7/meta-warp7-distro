SUMMARY = "Mender state script"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI += " \
    file://Download_Enter_00 \
"

inherit mender-state-scripts

S = "${WORKDIR}"

do_compile() {
	cp Download_Enter_00 ${MENDER_STATE_SCRIPTS_DIR}/
}
