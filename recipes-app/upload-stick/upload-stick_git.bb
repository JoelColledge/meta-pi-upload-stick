inherit cargo systemd

FILESPATH = "/home/jrc/src"
SRC_URI = "file://upload-stick"

SRCREV = "${AUTOREV}"
LIC_FILES_CHKSUM="file://LICENSE-MIT;md5=356b8585f2d6f8457e47f2e504787626"

SUMMARY = "Hello World by Cargo for Rust"
# HOMEPAGE = "https://github.com/jmesmon/rust-hello-world"
LICENSE = "MIT"

S = "${WORKDIR}/upload-stick"

SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "upload-stick-start.service"
SYSTEMD_AUTO_ENABLE = "enable"

do_install_append() {
             install -d ${D}${systemd_system_unitdir}
             install -m 0644 ${S}/upload-stick-prepare.service ${D}${systemd_system_unitdir}
             install -m 0644 ${S}/upload-stick-start.service ${D}${systemd_system_unitdir}
}

BBCLASSEXTEND = "native"
