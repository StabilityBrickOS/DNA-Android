if [ ! -d $DNA_PRO/out ];then
 mkdir -p $DNA_PRO/out
fi

for i in $ZST; do
    if [ ! -f "$DNA_PRO/$i" ]; then
        echo "错误: 文件 $DNA_PRO/$i 不存在!"
        continue
    fi
    if expr "$i" : '.*\.zst$' >/dev/null || expr "$i" : '.*\.zstd$' >/dev/null; then
        echo "> 开始解压: $i"
        line=$(echo "$i" | cut -d"." -f1)
        zstd -d -k -f $DNA_PRO/$i -o $DNA_PRO/out/$line.img
        echo "> 解压完成，文件位于：$DNA_PRO/out/$line.img"
    fi
    if expr "$i" : '.*\.img$' >/dev/null; then
        echo "> 开始压缩：$i "
        zstd -$level -T4 -f $DNA_PRO/$i -o $DNA_PRO/out/$i.zst
        echo "> 压缩完成，文件位于：$DNA_PRO/out/$i.zst"
    fi
    if [[ $silence = 1 ]]; then
        echo "> 删除: $i"
        rm -rf "$DNA_PRO/$i"
    fi
done

