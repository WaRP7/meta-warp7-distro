SUMMARY = "Mender state script"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Apache-2.0;md5=89aea4e17d99a7cacdbeed46a0096b10"

SRC_URI += " \
	file://Sync_Enter_00 \
    file://Download_Enter_00 \
    file://ArtifactReboot_Enter_00 \
    file://ArtifactCommit_Enter_00 \
"

inherit mender-state-scripts

S = "${WORKDIR}"

do_compile() {
	cp Sync_Enter_00 ${MENDER_STATE_SCRIPTS_DIR}/
	cp Download_Enter_00 ${MENDER_STATE_SCRIPTS_DIR}/
	cp ArtifactReboot_Enter_00 ${MENDER_STATE_SCRIPTS_DIR}/
	cp ArtifactCommit_Enter_00 ${MENDER_STATE_SCRIPTS_DIR}/
}
