DESCRIPTION = "Minimal Scheme Implementation for use as an Extension Language"
HOMEPAGE = "http://synthcode.com/wiki/chibi-scheme/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=6efd716f2ac77e801aa6520d28dfb04e"

SRC_URI = "http://synthcode.com/scheme/chibi/chibi-scheme-${PV}.tgz"
SRC_URI[md5sum] = "859753dc88d0a7388f0b62859cd3064b"
SRC_URI[sha256sum] = "21a0cf669d42a670a11c08f50dc5aedb7b438fae892260900da58f0ed545fc7d"

S = "${WORKDIR}/chibi-scheme-${PV}"

DEPENDS = "chibi-native"
DEPENDS_virtclass-native = ""

# CHIBI_NATIVE is the chibi-native workdir path. It's used to create all libs,
# docs and make some tests on building.
CHIBI_NATIVE = "${BASE_WORKDIR}/${BUILD_SYS}/chibi-native/${PV}-${PR}/chibi-scheme-${PV}/chibi-scheme"
EXTRA_OEMAKE += "CHIBI=${CHIBI_NATIVE}"
EXTRA_OEMAKE_virtclass-native += ""

do_compile(){
    oe_runmake PREFIX=${prefix}
}
do_install(){
    oe_runmake install DESTDIR=${D} PREFIX=${prefix}
}

FILES_${PN}     += "${includedir}/chibi/* \
                    ${libdir}/pkgconfig/chibi-scheme.pc \
                    "
FILES_${PN}-dev += "${libdir}/libchibi-scheme.so"
FILES_${PN}-dbg += "${libdir}/chibi/*/*/.debug \
                    ${libdir}/chibi/*/.debug \
                    "
BBCLASSEXTEND = "native"
