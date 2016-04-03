chrome.tabs.onUpdated.addListener(function(tabId, changeInfo) {
    if (changeInfo.status == 'complete') {

        chrome.tabs.query({
            active: true,
            lastFocusedWindow: true
        }, function(tabs) {
        var tab = tabs[0];
        var currUrl = tab.url;
        alert(currUrl);
        });

    }
});
