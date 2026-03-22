val=$1
case ${val} in
dir)
ls -F $DNA_DRO | sed 's/\/$//g' | grep -v "config"
;;
zip1)
ls $DNA_DIR | grep -v "/$" | grep \."zip"$
;;
img1)
ls $DNA_DIR | grep -v "/$" | grep \."img"$
;;
br)
ls $DNA_PRO | grep -v "/$" | grep \."br"$
;;
dat)
ls $DNA_PRO | grep -v "/$" | grep \."new.dat"$
;;
img)
for i in $(ls $DNA_PRO | grep -v "/$" | grep \."img"$)
do
    if [ -f $DNA_PRO/$i ];then
        info=$(dna gettype $DNA_PRO/$i)
        echo "$i|$i ($info)"
    fi
done
;;
split_sparse)
find "$DNA_PRO" -maxdepth 1 -type f -exec basename {} \; | 
    sed -n 's/\(.*\)\.[0-9]\{1,\}$/\1/p; t; d' |
    sort | uniq -c | 
    while read -r count prefix; do
        clean_prefix=$(echo "$prefix" | sed 's/[^a-zA-Z0-9._-]$//')
        printf "%s|%s Total %d files\n" "$clean_prefix" "$clean_prefix" "$count"
    done
;;
zst_img)
ls $DNA_PRO | grep -v "/$" | grep -E "\.(zst|zstd|img)$"
;;
*)
ls $DNA_PRO | grep -v "/$" | grep \."$1"$
;;
esac
