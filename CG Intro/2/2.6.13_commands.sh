ffmpeg -i input_video.mp4 -ss 00:00:30 -t 00:00:10 -c:v copy cropped.mp4
convert -depth 8 -background none -resize 50% plate.svg plate.png
ffmpeg -i cropped.mp4 -i plate.png -filter_complex "overlay=0:446:enable=between(t\,1\,9)" plated.mp4
ffmpeg -i plated.mp4 -vf "drawtext=enable='between(t,2,9)': fontfile=Arial.ttf: text='I am learning computer graphics!': fontcolor=black: fontsize=16: x=200: y=476" result.mp4