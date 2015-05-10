DESCRIPTION = "Minimal Scheme Implementation for use as an Extension Language"
HOMEPAGE = "http://synthcode.com/wiki/chibi-scheme/"
LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://COPYING;md5=6efd716f2ac77e801aa6520d28dfb04e"

SRC_URI = "git://github.com/ashinn/chibi-scheme.git"
SRC_URI[md5sum] = "869d99bbcd500266a7d9dd530db6483b"
SRC_URI[sha256sum] = "2892b6c5145e1506d814d42fbdce20a6bde1d766dbe78af30500301e189918f7"
SRCREV = "master"

S = "${WORKDIR}/git"

DEPENDS = "chibi-native"
DEPENDS_virtclass-native = ""

# CHIBI_NATIVE is the chibi-native workdir path. It's used to create all libs,
# docs and make some tests on building.
CHIBI_NATIVE = "${BASE_WORKDIR}/${BUILD_SYS}/chibi-native/${PV}-${PR}/git/chibi-scheme"
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
