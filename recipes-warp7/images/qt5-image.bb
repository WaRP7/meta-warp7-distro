DESCRIPTION = "Qt image"
LICENSE = "MIT"

inherit base-image populate_sdk_qt5

IMAGE_INSTALL += "\
	packagegroup-qt5 \
"

export IMAGE_BASENAME = "qt5-image"
