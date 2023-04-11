# Monopoly Deal

## Configure Commit Lint Hook

```shell
$ chmod ug+x .githooks/*
$ git config core.hooksPath .githooks
```

[🌈Conventional Commits😋](https://www.conventionalcommits.org/en/v1.0.0/)

## Class Diagram

```mermaid
classDiagram
	AbstractCard <|-- MoneyCard
	AbstractCard <|-- ActionCard
	AbstractCard <|-- PropertyCard
	MoneyCard <|-- IBankCard
	ActionCard <|-- IBankCard
	
	class AbstractCard
		<<Abstract>> AbstractCard
		AbstractCard : -String name
		AbstractCard : -CardTyps type
		AbstractCard : -int value
		AbstractCard : -String description
		AbstractCard : play()*
		
	class MoneyCard
	
	class ActionCard
	
	class PropertyCard
	
	class IBankCard
		<<Interface>> IBankCard
```
