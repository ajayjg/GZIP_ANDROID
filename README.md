# GZIP_ANDROID
GZIP Compressor &amp; Decompressor which also includes GZIP frame checking function.

Gzip is a file format and a software application used for file compression and decompression. gzip is based on the DEFLATE algorithm, which is a combination of LZ77 and Huffman coding. DEFLATE was intended as a replacement for LZW and other patent-encumbered data compression algorithms which, at the time, limited the usability of compress and other popular archivers.


"Gzip" file format, which is:
•	a 10-byte header, containing a magic number (1f 8b), compression ID (08 for DEFLATE), file flags, a 32-bit timestamp, compression flags and operating system ID.
•	optional extra headers denoted by file flags, such as the original filename
•	a body, containing a DEFLATE-compressed payload
•	an 8-byte footer, containing a CRC-32 checksum and the length of the original uncompressed data, modulo .[3]

**Important Note

Gzip is not to be confused with the ZIP archive format, which also uses DEFLATE. The ZIP format can hold collections of files without an external archiver, but is less compact than compressed tarballs holding the same data, because it compresses files individually and cannot take advantage of redundancy between files (solid compression).

