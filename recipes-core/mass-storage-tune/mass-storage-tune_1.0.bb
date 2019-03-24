SUMMARY = "USB storage tuning"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "file://dirty.conf"

do_install () {
        install -d ${D}${sysconfdir}/sysctl.d
        install -m 644 ${WORKDIR}/dirty.conf ${D}${sysconfdir}/sysctl.d/dirty.conf
}
