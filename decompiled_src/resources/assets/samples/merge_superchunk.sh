project=$(cat $TMPDIR/DNA.ini)
DNA_PRO=$DNA_DIR/$project
if [ ! -d $DNA_PRO/out ];then
 mkdir -p $DNA_PRO/out
fi

for prefix in $IMG; do
    safe_prefix=$(printf "%s" "$prefix" | sed 's/[.[*^$+(){}|]/\\&/g')
    pattern="^${safe_prefix}\.[0-9]\\{1,\\}$"
    find "$DNA_PRO" -maxdepth 1 -type f -name "${prefix}*" -exec basename {} \; |
    grep "$pattern" |
    tr '\n' ' ' |
    {
        read -r files
        cd $DNA_PRO
        echo "> 开始将文件合并到：$prefix"
        simg2img ${files% } $DNA_PRO/out/$prefix
        cd
        if [ -f $DNA_PRO/out/$prefix ];then
            echo "> 转换完成，文件位于：$DNA_PRO/out/$prefix"
        else
            echo "DEBUG: > 处理独立前缀 '$prefix'" >&2
            echo "DEBUG: > 生成正则模式 '$pattern'" >&2
            echo "DEBUG: > 处理'${files% }'失败，请截图联系开发者修复" >&2
        fi
    }
done
