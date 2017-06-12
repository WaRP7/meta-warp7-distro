DESCRIPTION = "Qt image"
LICENSE = "MIT"

inherit base-image

IMAGE_INSTALL += "\
	packagegroup-qt5 \
	qtserialbus \
"

export IMAGE_BASENAME = "qt5-image"
