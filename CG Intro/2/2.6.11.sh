ffmpeg -i in.mp4 -i logo.png -filter_complex "overlay=20:20:enable=between(t\,2\,8)" -c:a copy out.mp4