function debounce(callee, timeoutMs) {
  return function perform(...args) {
    let previousCall = this.lastCall
    this.lastCall = Date.now()
    if (previousCall && this.lastCall - previousCall <= timeoutMs) {
      clearTimeout(this.lastCallTimer)
    }
    this.lastCallTimer = setTimeout(() => callee(...args), timeoutMs)
  }
}

async function handleSearchItems(e) {
  const { value } = e.target
  let page = { pageNumber: pagingNumber, pageSize: 15 };
  let items = await itemFetch.getItemsLikeName(value, page)
    .then(res => res.json())
    .then(items => items);
  await itemsForeach(items);
}

async function callSearch() {
  const searchItem = document.getElementById('searchItems');
  const debouncedHandle = debounce(await handleSearchItems, 150)
  searchItem.addEventListener('input', debouncedHandle);
}