Feature: Reading Excel into Feature File

Scenario Outline: Test to read Excel into Feature File
Given User fills form using sheetname "<SheetName>" and rownumber <RowNum>
  Examples:
  |SheetName|RowNum|
  | TestSheet  | 0  |

  Scenario: Excel Read Test
    Given User fills form using excel