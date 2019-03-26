DESCRIPTION = "A command line program to sync files and directories to and from different cloud storage providers."
SECTION = "utils"
HOMEPAGE = "https://rclone.org/"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://src/${GO_IMPORT}/COPYING;md5=bed161b82a1ecab65ff7ba3c3b960439"

GO_IMPORT = "github.com/ncw/rclone"
SRC_URI = "git://github.com/ncw/rclone.git \
           file://0001-Run-python-scripts-using-env.patch"
SRCREV = "eb85ecc9c480175bd39a2009212ffa81eaebee7c"

inherit go

# link libstd.so statically
GO_LINKSHARED = ""

RDEPENDS_${PN}-dev += "bash"
