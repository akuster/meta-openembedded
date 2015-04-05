DESCRIPTION = "fingerterm is a terminal emulator designed for touch-based interaction, specifically for (but not limited to) use on the Nokia N9 and Jolla's Jolla device."
SECTION = "qt/app"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"


SRCREV = "5c74711c3a18237ff26d9d583c09d49cd0c09a6e"

PV = "1.1.14+git${SRCPV}"

SRC_URI = "git://github.com/nemomobile/fingerterm.git"


S = "${WORKDIR}/git"

inherit qt4x11 pkgconfig

do_install() {
    install -d ${D}${bindir}
    install -m 0755 ${S}/${PN} ${D}${bindir}

    sed -i -e '/Exec.*/d' fingerterm.desktop
    sed -i -e '/Icon.*/d' fingerterm.desktop

    echo 'Exec=${bindir}/${PN}' >> fingerterm.desktop
    echo 'Icon=${PN}' >> fingerterm.desktop

    install -d ${D}${datadir}/applications
    install -m 0644 ${S}/${PN}.desktop ${D}${datadir}/applications

    install -d ${D}${datadir}/pixmaps
    install -m 0644 ${S}/${PN}.png ${D}${datadir}/pixmaps
}

FILES_${PN} = " \
    ${bindir}/${PN} \
    ${datadir}/applications/${PN}.desktop \
    ${datadir}/pixmaps/${PN}.png \
"
