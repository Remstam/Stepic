convert sunset.cr2 -depth 16 PNG16.png
convert sunset.cr2 -depth 8  PNG8.png
convert sunset.cr2 -compress LossLess -depth 8 JLL.jpg
convert sunset.cr2 -define webp:lossless=true -depth 8 WLL.webp
convert sunset.cr2 -quality 60 -depth 8 J60.jpg
convert sunset.cr2 -quality 30 -depth 8 J30.jpg
convert sunset.cr2 -quality 60 -depth 8 W60.webp
convert sunset.cr2 -quality 30 -depth 8 W30.webp
convert sunset.cr2 -define jpeg:extent=64kb -depth 8 JW60.jpg