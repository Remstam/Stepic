convert PNG16.png  PNG8.png -compose difference -composite -depth 8 PNG16-PNG8.png
convert PNG8.png   JLL.jpg  -compose difference -composite -depth 8 PNG8-JLL.png
convert PNG8.png   WLL.webp -compose difference -composite -depth 8 PNG8-WLL.png
convert sunset.cr2 W60.webp -compose difference -composite -depth 8 CR2-W60.png
convert sunset.cr2 JW60.jpg -compose difference -composite -depth 8 CR2-JW60.png
convert W60.webp   JW60.jpg -compose difference -composite -depth 8 W60-JW60.png