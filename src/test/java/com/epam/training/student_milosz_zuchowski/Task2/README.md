# Practical Task 2 - Locators

## Automated flow
epam.com → Accept cookies → Careers → Start your search → Keywords "Java"
→ SEARCH → latest job

### Not clicked in the test:
- Location — default is already "All available countries"
- Remote — checkbox is inside FILTERS, not in DOM until the panel is open


## Locator mapping
| Element | Locator type | Locator                                                                     |
|---|---|-----------------------------------------------------------------------------|
| Accept All | 1 id | `By.id("onetrust-accept-btn-handler")`                                      |
| Keywords | 2 name | `By.name("search")`                                                         |
| First job title (class from Inspect) | 3 className | `By.className("JobCard_labelLink__cslqy")`                                  |
| Job heading | 4 tagName | `By.tagName("h1")`                                                          |
| Careers | 5 linkText | `By.linkText("Careers")`                                                    |
| Back to Search | 6 partialLinkText | `By.partialLinkText("Back to Search")`                                      |
| Start your search | 7 cssSelector | `By.cssSelector(".pinned-button a[href*='/jobs']")`                         |
| SEARCH | 8 xpath (relative) | `By.xpath("//button[@type='submit']")`                                      |
| First vacancy | 9 xpath + contains | `By.xpath("(//a[contains(@href,'/vacancy/')])[1]")`                         |
| SEARCH from keyword / Remote | 10 xpath + axis | `By.xpath("./ancestor::form//button[@type='submit']")`                      |
| Remote (not clicked) | 10 xpath + axis | `By.xpath("//input[@name='vacancy.type-Remote']/following-sibling::label")` |
| Location option (not clicked) | 9 xpath + contains | `By.xpath("//*[@role='option' and contains(.,'All available countries')]")` |
