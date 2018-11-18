let mergeConvertibly(list1, list2) =
  let rec innerMergeConvertibly(outcome, list1, list2) = 
    match (list1, list2) with 
    ([],[])-> List.rev outcome
    |(hd::tl, secondList)-> innerMergeConvertibly(hd::outcome, secondList, tl)
    |([], secondList) -> innerMergeConvertibly(outcome, secondList, [])
    in innerMergeConvertibly([], list1, list2);;

mergeConvertibly([1;3;4],[2;7;8]);;
mergeConvertibly([3;8;9], []);;
mergeConvertibly([], [3;8;9]);;
mergeConvertibly([], []);;