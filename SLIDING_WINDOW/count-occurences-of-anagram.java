// maintain the object with count of letter for anagram word
// eg deepak word \
// {
// 'd':1,
// 'e':2,
// 'p':1,
// 'a':1,
// 'k':1,
// }

// for each letter in window decrement the letter count for each letter found in
// the window
// if count of each letter is 0 then anagram found
// if letter is removed from window do -\+1 in angarm object and if add then
// -1 in angram object